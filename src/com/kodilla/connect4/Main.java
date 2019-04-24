package com.kodilla.connect4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

//    Board board = new Board();
//    Layout layout = new Layout();
//    Engine engine = new Engine();

    static Stage stage;
//    Scene scene;
//    Stage primaryStage;


    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        Layout layout;

        displayStart();
    }

    public static void displayStart() {
        Board board = new Board();
        Layout layout = new Layout();
        Engine engine = new Engine();

        VBox mainWindow = new VBox(5);
        HBox starters = new HBox(5);
        starters.setAlignment(Pos.CENTER);
        HBox service = new HBox(10);
        service.setAlignment(Pos.CENTER);
        HBox yard = new HBox();
        yard.setAlignment(Pos.CENTER);

        Shape playground = layout.makeGrid();
        Pane discField = new Pane();
        discField.setMaxSize(705, 610);

        Button button1 = new Button("Column One");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 1);

                engine.buttonHandling(board, discField);
            }

        });

        Button button2 = new Button("Column Two");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 2);

                engine.buttonHandling(board, discField);
            }

        });

        Button button3 = new Button("Column Three");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 3);

                engine.buttonHandling(board, discField);
            }

        });

        Button button4 = new Button("Column Four");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 4);

                engine.buttonHandling(board, discField);
            }

        });

        Button button5 = new Button("Column Five");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 5);

                engine.buttonHandling(board, discField);
            }

        });

        Button button6 = new Button("Column Six");
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 6);

                engine.buttonHandling(board, discField);
            }

        });

        Button button7 = new Button("Column Seven");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 7);

                engine.buttonHandling(board, discField);
            }

        });

        service.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7);
        yard.getChildren().add(playground);
        yard.getChildren().add(discField);
        mainWindow.getChildren().addAll(service, yard);

        Scene scene = new Scene(mainWindow, 705, 640, Color.LIGHTBLUE);

        stage.setTitle("ConnectFour");
        stage.setScene(scene);

        stage.show();
    }
    public static void displayWin() {

        VBox winnerScreen = new VBox();
        Label info = new Label("You win, congratulations! Do you want to play again?");
        info.setFont(new Font(20));
        Button again = new Button("YES");
        Button nope = new Button("NO");
        winnerScreen.getChildren().addAll(info, again, nope);
        Scene winnerScene = new Scene(winnerScreen, 500, 400);

        stage.setScene(winnerScene);
        stage.show();

        again.setOnAction(e -> displayStart());
        nope.setOnAction(e -> System.exit(-1));
    }

    public static void displayLose() {

        VBox winnerScreen = new VBox();
        Label info = new Label("Such a shame, you've lost! Do you want to play again?");
        info.setFont(new Font(20));
        Button again = new Button("YES");
        Button nope = new Button("NO");
        winnerScreen.getChildren().addAll(info, again, nope);
        Scene winnerScene = new Scene(winnerScreen, 500, 400);

        stage.setScene(winnerScene);
        stage.show();

        again.setOnAction(e -> displayStart());
        nope.setOnAction(e -> System.exit(-1));
    }
}











