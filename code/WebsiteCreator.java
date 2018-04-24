import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.*; 
import javafx.animation.*;
import javafx.geometry.*;
import nu.xom.*;
import java.io.*;
import java.util.*;
//for file open at end
import java.awt.Desktop;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.TableColumn.*;
import javafx.util.converter.*;

public class WebsiteCreator extends Application 
{
    //HW FINAL PROJECT - Website Creator V1.0
    //EVAN LEIDER
    public static void main(String[] args) 
    {
        // Automatic VM reset, thanks to Joseph Rachmuth.
        try
        {
            launch(args);
            System.exit(0);
        }
        catch (Exception error)
        {
            error.printStackTrace();
            System.exit(0);
        }
    }

    public void start(Stage mainStage) 
    {
        //set title
        mainStage.setTitle("Website Creator v1.0 - Evan Leider");

        //add borderpane for menu
        BorderPane root = new BorderPane();

        //main vbox
        VBox main = new VBox();
        main.setPadding( new Insets(16) );
        main.setSpacing(4);
        main.setAlignment( Pos.CENTER );

        //main hbox (below global settings,  pages)
        HBox hbox = new HBox();
        hbox.setSpacing(16);
        hbox.setAlignment( Pos.CENTER );

        //focus on VBox
        root.setCenter(main);

        //setup scene
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

        // add application icon
        mainStage.getIcons().add( new Image("assets/globe.png") );

        // add stylesheet
        mainScene.getStylesheets().add("assets/stylesheet.css");
        // custom code below --------------------------------------------

        //LAYOUT OBJECTS SETUP

        //Global Settings
        //vbox
        VBox gSetVbox = new VBox();
        gSetVbox.setPadding( new Insets(16) );
        gSetVbox.setSpacing(16);
        gSetVbox.setAlignment( Pos.TOP_CENTER );
        Label gNameLabel = new Label("Global Settings");

        //Create Labels
        Label gLabel1 = new Label("NavBar Background Color: ");
        Label gLabel2 = new Label("NavBar Font Color: ");
        Label gLabel3 = new Label("Background Color: ");
        Label gLabel4 = new Label("Font Color: ");
        Label gLabel5 = new Label("Google WebFont URL: ");

        //ColorPick - Div Navbar Background Color
        ColorPicker divBGColorPicker = new ColorPicker();
        divBGColorPicker.setValue(Color.GREY);

        //ColorPick - Div Navbar Font Color Picker
        ColorPicker divFontColorPicker = new ColorPicker();
        divFontColorPicker.setValue(Color.WHITE);

        //ColorPick - Background Color
        ColorPicker bgColorPicker = new ColorPicker();
        bgColorPicker.setValue(Color.BLACK);

        //ColorPick - Font Color Picker
        ColorPicker fontColorPicker = new ColorPicker();
        fontColorPicker.setValue(Color.WHITE);

        //Text Field - Google WebFont URL
        TextField gField = new TextField();
        gField.setLayoutX(10);
        gField.setLayoutY(75);
        gField.setPrefWidth(350);

        //Create Grid Pane, topGrid (Global Settings)
        GridPane topGrid = new GridPane();
        topGrid.setPadding( new Insets(8) );
        topGrid.setHgap(8);
        topGrid.setVgap(4);
        //debug
        //topGrid.setGridLinesVisible(true);

        //add labels to grid
        topGrid.add(gLabel1, 0, 0);
        topGrid.add(gLabel2, 0, 1);
        topGrid.add(gLabel3, 3, 0);
        topGrid.add(gLabel4, 3, 1);

        //add color pickers/ text field to grid
        topGrid.add(divBGColorPicker, 1, 0);
        topGrid.add(divFontColorPicker, 1, 1); 
        topGrid.add(bgColorPicker, 4, 0);
        topGrid.add(fontColorPicker, 4, 1);

        //URL HBox for Google Web Font
        HBox urlHBox = new HBox();
        urlHBox.setAlignment(Pos.CENTER);
        urlHBox.getChildren().addAll(gLabel5, gField);

        //Align Center
        topGrid.setAlignment(Pos.CENTER);
        gSetVbox.getChildren().addAll(gNameLabel, topGrid, urlHBox);
        //end Global Settings

        //Page1_______________________________________________
        //vbox
        VBox page1 = new VBox();
        page1.setPadding( new Insets(16) );
        page1.setSpacing(16);
        page1.setAlignment( Pos.TOP_CENTER );
        Label nameLabel = new Label("Home");

        //Create Labels
        Label titleLabel = new Label("Page Title: ");
        titleLabel.setAlignment( Pos.CENTER_RIGHT );
        Label s1Label = new Label("Text Title: ");
        Label p1Label = new Label("Text: ");
        Label s2Label = new Label("Text Title: ");
        Label p2Label = new Label("Text: ");
        Label s3Label = new Label("Text Title: ");
        Label p3Label = new Label("Text: ");

        //Text Area - title
        TextField titleField = new TextField();
        titleField.setLayoutX(10);
        titleField.setLayoutY(75);
        titleField.setAlignment( Pos.CENTER );

        //Text Field - s1 (section)
        TextField s1Field = new TextField();
        s1Field.setLayoutX(10);
        s1Field.setLayoutY(75);

        //Text Area - p1
        TextArea p1Area = new TextArea();
        p1Area.setLayoutX(10);
        p1Area.setLayoutY(75);
        p1Area.setPrefColumnCount(3);
        p1Area.setPrefRowCount(2);

        //Text Field - s2 (section)
        TextField s2Field = new TextField();
        s2Field.setLayoutX(10);
        s2Field.setLayoutY(75);

        //Text Area - p2
        TextArea p2Area = new TextArea();
        p2Area.setLayoutX(10);
        p2Area.setLayoutY(75);
        p2Area.setPrefColumnCount(3);
        p2Area.setPrefRowCount(2);

        //Text Field - s3 (section)
        TextField s3Field = new TextField();
        s3Field.setLayoutX(10);
        s3Field.setLayoutY(75);

        //Text Area - p3
        TextArea p3Area = new TextArea();
        p3Area.setLayoutX(10);
        p3Area.setLayoutY(75);
        p3Area.setPrefColumnCount(3);
        p3Area.setPrefRowCount(2);

        //Create Grid Pane
        GridPane grid = new GridPane();
        grid.setPadding( new Insets(8) );
        grid.setHgap(8);
        grid.setVgap(4);
        //debug
        //grid.setGridLinesVisible(true);

        //add labels to grid
        grid.add(titleLabel, 0, 0);
        grid.add(s1Label, 0, 1);
        grid.add(p1Label, 0, 2);
        grid.add(s2Label, 0, 3);
        grid.add(p2Label, 0, 4);
        grid.add(s3Label, 0, 5);
        grid.add(p3Label, 0, 6);

        //add text Areas to grid
        grid.add(titleField, 1, 0);
        grid.add(s1Field, 1, 1); 
        grid.add(p1Area, 1, 2);
        grid.add(s2Field, 1, 3);
        grid.add(p2Area, 1, 4);
        grid.add(s3Field, 1, 5);
        grid.add(p3Area, 1, 6);

        //Align Center
        grid.setAlignment(Pos.CENTER);
        page1.getChildren().addAll(nameLabel, grid);
        //end Page1___________________________________________

        //Page2_______________________________________________
        //vbox
        VBox page2 = new VBox();
        page2.setPadding( new Insets(16) );
        page2.setSpacing(16);
        page2.setAlignment( Pos.TOP_CENTER );
        Label nameLabel2 = new Label("About");

        //Create Labels
        Label titleLabel2 = new Label("Page Title: ");
        Label s1Label2 = new Label("Text Title: ");
        Label p1Label2 = new Label("Text: ");

        //Text Area - title
        TextField titleField2 = new TextField();
        titleField2.setLayoutX(10);
        titleField2.setLayoutY(75);
        titleField2.setAlignment( Pos.CENTER );

        //Text Field - s1 (section)
        TextField s1Field2 = new TextField();
        s1Field2.setLayoutX(10);
        s1Field2.setLayoutY(75);

        //Text Area - p1
        TextArea p1Area2 = new TextArea();
        p1Area2.setLayoutX(10);
        p1Area2.setLayoutY(75);
        p1Area2.setPrefColumnCount(3);
        p1Area2.setPrefRowCount(2);

        //Create Grid Pane
        GridPane grid2 = new GridPane();
        grid2.setPadding( new Insets(8) );
        grid2.setHgap(8);
        grid2.setVgap(4);
        //debug
        //grid2.setGridLinesVisible(true);

        //add labels to grid
        grid2.add(titleLabel2, 0, 0);
        grid2.add(s1Label2, 0, 1);
        grid2.add(p1Label2, 0, 2);

        //add text Areas to grid
        grid2.add(titleField2, 1, 0);
        grid2.add(s1Field2, 1, 1); 
        grid2.add(p1Area2, 1, 2);

        //Align Center
        grid2.setAlignment(Pos.CENTER);
        page2.getChildren().addAll(nameLabel2, grid2);
        //end Page2_________________________________________

        //Page 3____________________________________________
        //vbox
        VBox page3 = new VBox();
        page3.setPadding( new Insets(16) );
        page3.setSpacing(16);
        page3.setAlignment( Pos.TOP_CENTER );
        Label nameLabel3 = new Label("Contact");

        //Create Labels
        Label titleLabel3 = new Label("Page Title: ");
        Label s1Label3 = new Label("Text Title: ");
        Label p1Label3 = new Label("Text: ");
        Label p2Label3 = new Label("Email: ");

        //Text Area - title
        TextField titleField3 = new TextField();
        titleField3.setLayoutX(10);
        titleField3.setLayoutY(75);
        titleField3.setAlignment( Pos.CENTER );

        //Text Field - s3 (section)
        TextField s1Field3 = new TextField();
        s1Field3.setLayoutX(10);
        s1Field3.setLayoutY(75);

        //Text Area - p1
        TextArea p1Area3 = new TextArea();
        p1Area3.setLayoutX(10);
        p1Area3.setLayoutY(75);
        p1Area3.setPrefColumnCount(3);
        p1Area3.setPrefRowCount(2);

        //Text Field - p2
        TextField p2Field3 = new TextField();
        p2Field3.setLayoutX(10);
        p2Field3.setLayoutY(75);

        //Create Grid Pane
        GridPane grid3 = new GridPane();
        grid3.setPadding( new Insets(8) );
        grid3.setHgap(8);
        grid3.setVgap(4);
        //debug
        //grid3.setGridLinesVisible(true);

        //add labels to grid
        grid3.add(titleLabel3, 0, 0);
        grid3.add(s1Label3, 0, 1);
        grid3.add(p1Label3, 0, 2);
        grid3.add(p2Label3, 0, 3);

        //add text Areas/fields to grid
        grid3.add(titleField3, 1, 0);
        grid3.add(s1Field3, 1, 1); 
        grid3.add(p1Area3, 1, 2); 
        grid3.add(p2Field3, 1, 3);

        //Align Center
        grid3.setAlignment(Pos.CENTER);
        page3.getChildren().addAll(nameLabel3, grid3);
        //end Page 3________________________________________

        // menu bar
        MenuBar mb = new MenuBar();
        Menu m = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About/How to Use the Program");
        MenuItem quitItem = new MenuItem("Quit Website Creator");
        m.getItems().addAll(aboutItem, quitItem);
        mb.getMenus().
        add(m);

        //About
        aboutItem.setOnAction(
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    //About Popup
                    Alert infoAlert = new Alert(AlertType.INFORMATION);
                    infoAlert.setTitle("About Website Creator v1.0");
                    infoAlert.setHeaderText(null);
                    infoAlert.setContentText("Created by Evan Leider\n\nThis program creates 3 connected HTML webpages with "+
                        "an accompanying stylesheet.css based on your custom input and design. Each page includes a universal colored navigation bar.\n\n"+
                        "Use the color pickers and fields"+
                        " to customize your output website, and press Generate when you're done! Please don't leave page fields empty.\n\n"+
                        "You can add a custom URL from Google Web Fonts to add custom font to your generated HTML and CSS!\n\n" +
                        "To do this, pick a font on https://fonts.google.com/, select it and choose embed code. Copy the the url inside " +
                        "starting with https://fonts.googleapis.com/... " +
                        "and paste it into the app's font URL field.");
                    // Set Window Icon through Stage
                    Stage alertStage = (Stage) infoAlert.getDialogPane().getScene().getWindow();
                    alertStage.getIcons().add( new Image("assets/globe.png") );
                    infoAlert.showAndWait();
                }
            }
        );
        //Icon
        aboutItem.setGraphic( new ImageView( new Image("assets/information.png") ) );
        //Accelerator
        aboutItem.setAccelerator(
            new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN) );

        //Quit
        quitItem.setOnAction(
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    System.exit(0);
                }
            }
        );
        //Icon
        quitItem.setGraphic( new ImageView( new Image("assets/cancel.png") ) );
        //Accelerator
        quitItem.setAccelerator(
            new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN) );
        //set menu top
        root.setTop(mb);
        // custom code above --------------------------------------------

        //GENERATION BUTTON AND FUNCTIONALITY CODE
        //directoryChooser for Saving
        DirectoryChooser dirChooser = new DirectoryChooser();
        Button genButton = new Button("Generate!");
        genButton.setGraphic(new ImageView( new Image("assets/globe.png")));
        genButton.setOnAction(
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent e)
                {
                    //Create file holders
                    //html
                    File f1 = null;
                    File f2 = null;
                    File f3 = null;
                    //css
                    File c = null;
                    //body
                    try{
                        if
                        //empty checking
                        //page1
                        ( ( titleField.getText().equals("")) ||
                            /*
                            ( Double.parseDouble(d1.get()) < 0.0 ) ||
                            ( Integer.parseInt(i1.get()) < 0) ||
                             */
                            //more empty checking
                        ( s1Field.getText().equals("")) ||
                        ( p1Area.getText().equals("")) ||
                        ( s2Field.getText().equals("")) ||
                        ( p2Area.getText().equals("")) ||
                        ( s3Field.getText().equals("")) ||
                        ( p3Area.getText().equals("")) ||

                            //page2
                        ( titleField2.getText().equals("")) ||
                        ( s1Field2.getText().equals("")) ||
                        ( p1Area2.getText().equals("")) ||

                            //page3
                        ( titleField3.getText().equals("")) ||
                        ( s1Field3.getText().equals("")) ||
                        ( p1Area3.getText().equals("")) ||
                        ( p2Field3.getText().equals("")))

                        {
                            //Error String to hold what data types were empty.
                            String error = "You forgot to include some data: \n\n";
                            //Null String Checks
                            if( titleField.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Home Page Title\n";
                            }
                            if( s1Field.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Home Section Text 1\n";
                            }
                            if( p2Area.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Home Paragraph Text 1\n";
                            }
                            if( s2Field.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Home Section Text 2\n";
                            }
                            if( p3Area.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Home Paragraph Text 3\n";
                            }
                            if( s3Field.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Home Section Text 3\n";
                            }
                            //page 2
                            if( titleField2.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: About Page Title\n";
                            }
                            if( s1Field2.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: About Section Text\n";
                            }
                            if( p1Area2.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: About Paragraph Text\n";
                            }
                            //page 3
                            if( titleField3.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Contact Page Title\n";
                            }
                            if( s1Field3.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Contact Section Text\n";
                            }
                            if( p1Area3.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Contact Paragraph Text\n";
                            }
                            if( p2Field3.getText().equals("") )
                            {
                                //add data missing to error string
                                error += "\u2022 Missing: Contact Email\n";
                            }
                            /*
                            ( Double.parseDouble(d1.get()) < 0.0 ) ||
                            ( Integer.parseInt(i1.get()) < 0) ||
                             */
                            //more empty checking
                            /* Negative Number Check
                            //Error String to hold what data types were empty.
                            String error = "There are errors with your settings: \n\n";
                            if(
                            ( Double.parseDouble(d1.get()) < 0.0) ||
                            ( Integer.parseInt(i1.get()) < 0) )
                            {
                            //add data missing to error string
                            error += "\u2022 Negative Numbers Found - Please Use Positives\n";
                            }
                             */

                            //Let the user know what data wasn't entered, and to enter data
                            Alert infoAlert = new Alert(AlertType.ERROR);
                            infoAlert.setTitle("Data Error");
                            infoAlert.setHeaderText(null); 
                            infoAlert.setContentText(error + 
                                "\nPlease try again.");
                            infoAlert.showAndWait();
                        }
                        //Otherwise Save
                        else
                        {
                            File dir = dirChooser.showDialog(mainStage);
                            if (dir == null) 
                            {
                                //No directory
                                Alert infoAlert = new Alert(AlertType.WARNING);
                                infoAlert.setTitle("Warning Dialog");
                                infoAlert.setHeaderText(null); 
                                infoAlert.setContentText("No directory selected.");
                                infoAlert.showAndWait();
                            }
                            //create files
                            else {
                                //Initialize Files
                                //html
                                f1 = new File("");
                                f2 = new File("");
                                f3 = new File("");
                                //css
                                c = new File("");

                                //HTML PAGE 1 (HOME)______________________________________________________________________________________
                                //html tag
                                Element root = new Element("html");

                                //fontLink1 Element
                                Element fontLink = new Element("link");
                                fontLink.addAttribute(a("href", gField.getText()));
                                fontLink.addAttribute(a("rel", "stylesheet"));
                                fontLink.addAttribute(a("type", "text/css"));

                                //cssLink1 ELement
                                Element cssLink = new Element("link");
                                cssLink.addAttribute(a("rel", "stylesheet"));
                                cssLink.addAttribute(a("href", "stylesheet.css"));

                                Element head1 =
                                    e("head", 
                                        fontLink, 
                                        cssLink, 
                                        e("title", titleField.getText())
                                    );

                                root.appendChild(head1);

                                //header (navBar)
                                //DIV BAR
                                Element divBar1 =
                                    e("div",
                                        e("h1", titleField.getText())
                                    );
                                divBar1.addAttribute(a("id", "leftNavBar"));

                                //LINK HREFS
                                //A ELEMENT - LINK A HREF 1
                                Element nav1link1 = 
                                    e("a",
                                        e("h1", titleField.getText()) 
                                    );
                                nav1link1.addAttribute(a("href", "page1.html"));

                                //A ELEMENT - LINK A HREF 2
                                Element nav1link2 = 
                                    e("a",
                                        e("h1", titleField2.getText()) 
                                    );
                                nav1link2.addAttribute(a("href", "page2.html"));

                                //A ELEMENT - LINK A HREF 3
                                Element nav1link3 = 
                                    e("a",
                                        e("h1", titleField3.getText()) 
                                    );
                                nav1link3.addAttribute(a("href", "page3.html"));

                                //LIST
                                Element unOrderedList1 =
                                    e("ul",
                                        e("li", nav1link1),
                                        e("li", nav1link2),
                                        e("li", nav1link3)
                                    );
                                unOrderedList1.addAttribute(a("id", "rightNavList"));

                                Element header1 =
                                    e("header",
                                        divBar1,
                                        unOrderedList1
                                    );

                                root.appendChild(header1);

                                //body
                                Element body1 = 
                                    e("body",
                                        e("br", ""),
                                        e("h1", s1Field.getText()),
                                        e("p", p1Area.getText()),
                                        e("br", ""),
                                        e("h1", s2Field.getText()),
                                        e("p", p2Area.getText()),
                                        e("br", ""),
                                        e("h1", s3Field.getText()),
                                        e("p", p3Area.getText())
                                    );

                                //add the body
                                root.appendChild(body1);

                                // complete
                                Document doc1 = new Document(root);
                                //______________________________________________________END PAGE 1 (HOME)
                                //HTML PAGE 2 (ABOUT)______________________________________________________________________________________
                                //html tag
                                Element root2 = new Element("html");

                                //fontLink2 Element
                                Element fontLink2 = new Element("link");
                                fontLink2.addAttribute(a("href", gField.getText()));
                                fontLink2.addAttribute(a("rel", "stylesheet"));
                                fontLink2.addAttribute(a("type", "text/css"));

                                //cssLink2 ELement
                                Element cssLink2 = new Element("link");
                                cssLink2.addAttribute(a("rel", "stylesheet"));
                                cssLink2.addAttribute(a("href", "stylesheet.css"));

                                Element head2 =
                                    e("head", 
                                        fontLink2, 
                                        cssLink2, 
                                        e("title", titleField2.getText())
                                    );

                                root2.appendChild(head2);

                                //header (navBar)
                                //DIV BAR
                                Element divBar2 =
                                    e("div",
                                        e("h1", titleField2.getText())
                                    );
                                divBar2.addAttribute(a("id", "leftNavBar"));

                                //LINK HREFS
                                //A ELEMENT - LINK A HREF 1
                                Element nav2link1 = 
                                    e("a",
                                        e("h1", titleField.getText()) 
                                    );
                                nav2link1.addAttribute(a("href", "page1.html"));

                                //A ELEMENT - LINK A HREF 2
                                Element nav2link2 = 
                                    e("a",
                                        e("h1", titleField2.getText()) 
                                    );
                                nav2link2.addAttribute(a("href", "page2.html"));

                                //A ELEMENT - LINK A HREF 3
                                Element nav2link3 = 
                                    e("a",
                                        e("h1", titleField3.getText()) 
                                    );
                                nav2link3.addAttribute(a("href", "page3.html"));

                                //LIST
                                Element unOrderedList2 =
                                    e("ul",
                                        e("li", nav2link1),
                                        e("li", nav2link2),
                                        e("li", nav2link3)
                                    );
                                unOrderedList2.addAttribute(a("id", "rightNavList"));

                                Element header2 =
                                    e("header",
                                        divBar2,
                                        unOrderedList2
                                    );

                                root2.appendChild(header2);

                                //body
                                Element body2 = 
                                    e("body",
                                        e("br", ""),
                                        e("h1", s1Field2.getText()),
                                        e("p", p1Area2.getText())
                                    );

                                //add the body
                                root2.appendChild(body2);

                                // complete
                                Document doc2 = new Document(root2);
                                //______________________________________________________END PAGE 2 (ABOUT)

                                //HTML PAGE 3 (CONTACT US)______________________________________________________________________________________
                                //html tag
                                Element root3 = new Element("html");

                                //fontLink2 Element
                                Element fontLink3 = new Element("link");
                                fontLink3.addAttribute(a("href", gField.getText()));
                                fontLink3.addAttribute(a("rel", "stylesheet"));
                                fontLink3.addAttribute(a("type", "text/css"));

                                //cssLink2 ELement
                                Element cssLink3 = new Element("link");
                                cssLink3.addAttribute(a("rel", "stylesheet"));
                                cssLink3.addAttribute(a("href", "stylesheet.css"));

                                Element head3 =
                                    e("head", 
                                        fontLink3, 
                                        cssLink3, 
                                        e("title", titleField3.getText())
                                    );

                                root3.appendChild(head3);

                                //header (navBar)
                                //DIV BAR
                                Element divBar3 =
                                    e("div",
                                        e("h1", titleField3.getText())
                                    );
                                divBar3.addAttribute(a("id", "leftNavBar"));

                                //LINK HREFS
                                //A ELEMENT - LINK A HREF 1
                                Element nav3link1 = 
                                    e("a",
                                        e("h1", titleField.getText()) 
                                    );
                                nav3link1.addAttribute(a("href", "page1.html"));

                                //A ELEMENT - LINK A HREF 2
                                Element nav3link2 = 
                                    e("a",
                                        e("h1", titleField2.getText()) 
                                    );
                                nav3link2.addAttribute(a("href", "page2.html"));

                                //A ELEMENT - LINK A HREF 3
                                Element nav3link3 = 
                                    e("a",
                                        e("h1", titleField3.getText()) 
                                    );
                                nav3link3.addAttribute(a("href", "page3.html"));

                                //LIST
                                Element unOrderedList3 =
                                    e("ul",
                                        e("li", nav3link1),
                                        e("li", nav3link2),
                                        e("li", nav3link3)
                                    );
                                unOrderedList3.addAttribute(a("id", "rightNavList"));

                                Element header3 =
                                    e("header",
                                        divBar3,
                                        unOrderedList3
                                    );

                                root3.appendChild(header3);

                                //EMAIL LINK
                                //A ELEMENT - LINK A HREF 3
                                Element email = 
                                    e("a",
                                        e("h1", p2Field3.getText()) 
                                    );
                                email.addAttribute(a("href", "mailto:"+p2Field3.getText()));

                                //body
                                Element body3 = 
                                    e("body",
                                        e("br", ""),
                                        e("h1", s1Field3.getText()),
                                        e("p", p1Area3.getText()),
                                        email
                                    );

                                //add the body
                                root3.appendChild(body3);

                                // complete
                                Document doc3 = new Document(root3);
                                //______________________________________________________END PAGE 3 (CONTACT)

                                //SETUP CSS
                                //create font family string word
                                String url = gField.getText();
                                String start = "=";
                                //font family set and Splitter for multiple Capital Letters, adding spaces for the CSS
                                String family = url.substring(url.indexOf(start)+1, url.length());
                                String familySplit = "";
                                for(int i = 0; i < family.length(); i++)
                                {
                                    //Second Upper Exception Fix: if not first letter, and its +, create space instead
                                    if((i > 0) && (family.charAt(i) == '+'))
                                    {
                                        familySplit += " ";
                                    }
                                    //otherwise just add that character simply
                                    else
                                    {
                                        familySplit += family.charAt(i);
                                    }
                                }

                                //cssContent string (ALL CSS/STYLESHEET.CSS)
                                //HEADER (DIV NAV BAR)
                                String cssContent = "header {\n" +
                                        //text color
                                    "color: #" + ("" + divFontColorPicker.getValue()).substring(2,8) + ";\n" +
                                        //background color
                                    "background-color: #" + ("" + divBGColorPicker.getValue()).substring(2,8) + ";\n" +
                                    "max-width: 100%;\n" +
                                        //center align
                                    "text-align: left;\n" +
                                    "}\n\n" +

                                        //navbar Header list element css
                                    "header ul li {\n" +
                                    "margin-right: 20px;\n" +
                                    "display: inline-block;\n" +
                                    "}\n\n" +

                                        //body
                                    "body {\n" +
                                        //text color
                                    "color: #" + ("" + fontColorPicker.getValue()).substring(2,8) + ";\n" +
                                        //background color
                                    "background-color: #" + ("" + bgColorPicker.getValue()).substring(2,8) + ";\n" +
                                        //font set from CSS font family string above
                                    "font-family: " + familySplit + ";\n" +
                                        //center align
                                    "text-align: center;\n" +
                                    "}\n\n" +

                                        //more navBar header css
                                    "#leftNavBar {\n" +
                                    "display: inline-block;\n" +
                                    "text-align: left;\n" +
                                    "margin-top: 10px;\n" +
                                    "margin-left: 40px;\n" +
                                    "}\n\n" +

                                    "#rightNavList {\n" +
                                    "float: right;\n" +
                                    "display: inline-block;\n" +
                                    "list-style-type: none;\n" +
                                    "margin-right: 10px;\n" +
                                    "margin-bottom: 30px;\n" +
                                    "}\n\n";

                                //adjust files based on dir path
                                f1 = new File(dir.getAbsolutePath()+"\\page1.html");
                                f2 = new File(dir.getAbsolutePath()+"\\page2.html");
                                f3 = new File(dir.getAbsolutePath()+"\\page3.html");
                                c = new File(dir.getAbsolutePath()+"\\stylesheet.css");

                                //Create PrintWriter for css
                                PrintWriter pw = new PrintWriter(c);
                                try
                                {
                                    //HTML PAGE 1 SAVE
                                    OutputStream site1 = new FileOutputStream(f1);
                                    Serializer serial1 = new Serializer(site1, "ISO-8859-1");
                                    serial1.setIndent(4);
                                    serial1.setMaxLength(64);
                                    serial1.write(doc1);

                                    //HTML PAGE 2 SAVE
                                    OutputStream site2 = new FileOutputStream(f2);
                                    Serializer serial2 = new Serializer(site2, "ISO-8859-1");
                                    serial2.setIndent(4);
                                    serial2.setMaxLength(64);
                                    serial2.write(doc2);

                                    //HTML PAGE 3 SAVE
                                    OutputStream site3 = new FileOutputStream(f3);
                                    Serializer serial3 = new Serializer(site3, "ISO-8859-1");
                                    serial3.setIndent(4);
                                    serial3.setMaxLength(64);
                                    serial3.write(doc3);

                                    pw.println(cssContent);
                                }
                                catch (Exception error)
                                {
                                    System.out.println("Unable to generate.");
                                    System.exit(1);
                                }
                                //Close PrintWriter
                                pw.close();
                                //Open website files to show the result
                                Desktop.getDesktop().open(f3);
                                Desktop.getDesktop().open(f2);
                                Desktop.getDesktop().open(f1);
                            }
                        }
                    }
                    //If strings weren't convertable, (ex. illegal characters/empties were existant)
                    catch (NumberFormatException e1)
                    {
                        if
                        //empty checking
                        //page1
                        ( ( !titleField.getText().equals("")) &&
                            /*
                            ( Double.parseDouble(d1.get()) < 0.0 ) ||
                            ( Integer.parseInt(i1.get()) < 0) ||
                             */
                            //more empty checking
                        ( !s1Field.getText().equals("")) &&
                        ( !p1Area.getText().equals("")) &&
                        ( !s2Field.getText().equals("")) &&
                        ( !p2Area.getText().equals("")) &&
                        ( !s3Field.getText().equals("")) &&
                        ( !p3Area.getText().equals("")) &&

                            //page2
                        ( !titleField2.getText().equals("")) &&
                        ( !s1Field2.getText().equals("")) &&
                        ( !p1Area2.getText().equals("")) &&

                            //page3
                        ( !titleField3.getText().equals("")) &&
                        ( !s1Field3.getText().equals("")) &&
                        ( !p1Area3.getText().equals("")) &&
                        ( !p2Field3.getText().equals("")))
                        {
                            //Input
                            Alert infoAlert = new Alert(AlertType.INFORMATION);
                            infoAlert.setTitle("Check your input.");
                            infoAlert.setHeaderText(null); 
                            infoAlert.setContentText("Please use only acceptable characters.");
                            infoAlert.showAndWait();
                        }
                    }
                    //File related error
                    catch (Exception e2)
                    {
                        Alert infoAlert = new Alert(AlertType.INFORMATION);
                        infoAlert.setTitle("File Error");
                        infoAlert.setHeaderText(null); 
                        infoAlert.setContentText("Unable to generate files.");
                        infoAlert.showAndWait();
                        e2.printStackTrace();
                    }
                }
            }
        );

        //LAYOUT INITIALIZE

        //setup final hbox
        hbox.getChildren().addAll(page1, page2, page3);

        //add all general elements to main vBox
        main.getChildren().addAll(gSetVbox, hbox, genButton);

        //show stage
        mainStage.show();
    }

    // static helper methods
    public static Element e(String tagName, String text)
    {
        Element el = new Element(tagName);
        //add element to el
        el.appendChild(text);
        return el;
    }

    // note: use of varargs
    public static Element e(String tagName, Element... children)
    {
        Element el = new Element(tagName);
        //append children to each child element
        for (Element child : children)
        {
            el.appendChild(child);
        }
        return el;
    }

    public static Attribute a(String text, String text2)
    {
        Attribute at = new Attribute(text, text2);
        return at;
    }
}