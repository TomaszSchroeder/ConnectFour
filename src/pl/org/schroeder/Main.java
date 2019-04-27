package pl.org.schroeder;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        //stage = primaryStage;

        Layout.BuildLayout buildLayout = new Layout.BuildLayout();
        buildLayout.displayStart();
    }

}











