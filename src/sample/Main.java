package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//Ref Liang 10th ed Listing 4.5
//Shows a circle shape centered in the screen.
//The important feature of this code is the **"binding"** of the Circle to the Screen's size
//as the window/screen gets larger/smaller the circle automatically re-centers itself within
//the new screen size.


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();   //the "Pane" is a container
        //The PANE class may be used directly in cases where "absolute positioning of children is required"
        //since it does not perform layout beyond resizing resizable children to their preferred sizes.

        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2)); //the circle is now bound to the the pane's width
        circle.centerYProperty().bind(pane.heightProperty().divide(2)); ////the circle is now bound to the the pane's width
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        pane.getChildren().add(circle);

        //now we make a scene into which we place the "pane"
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Shows a contant circle in a resizable frame");
        //as the pane expands/shrinks in size the circle stays in the center (but does not increases/decrease in size)
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
