package pl.org.schroeder;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        //stage = primaryStage;
//        Engine engine = new Engine();

        Layout.BuildLayout buildLayout = new Layout.BuildLayout();
        buildLayout.displayStart();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Runnable inGame = new Runnable() {
//                    @Override
//                    public void run() {
//                        engine.afterTurns();
//                    }
//                };
//
//
//                    Platform.runLater(inGame);
//
//            }
//        });
//
//        thread.setDaemon(true);
//        thread.start();
    }
}











