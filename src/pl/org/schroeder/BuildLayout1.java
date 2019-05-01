package pl.org.schroeder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BuildLayout1 {

    static Stage stage;

    public BuildLayout1() {
    }

    public static Shape makeGrid() {
        Shape shape = new Rectangle(705, 610);

        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 7; x++) {
                Circle circle = new Circle(45);
                circle.setCenterX(45);
                circle.setCenterY(45);
                circle.setTranslateX(x * 95 + 20);
                circle.setTranslateY(y * 95 + 20);

                shape = Shape.subtract(shape, circle);
            }
        }

        Light.Distant light = new Light.Distant();
        light.setAzimuth(45.0);
        light.setElevation(30.0);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        shape.setFill(Color.BLUE);
        shape.setEffect(lighting);

        return shape;
    }

    public static Circle drawRedDisc(int xP, int yP, int radius) {

        Circle redDisc = new Circle(xP, yP, 45);
        redDisc.setFill(Color.RED);

        return redDisc;
    }

    public static Circle drawYellowDisc(int xP, int yP, int radius) {

        Circle redDisc = new Circle(xP, yP, 45);
        redDisc.setFill(Color.YELLOW);

        return redDisc;
    }

    public static void displayStart() {
        Stage stage = new Stage();
        Board board = new Board();

        Engine engine = new Engine();

        VBox mainWindow = new VBox(5);
        HBox starters = new HBox(5);
        starters.setAlignment(Pos.CENTER);
        HBox service = new HBox(10);
        service.setAlignment(Pos.CENTER);
        HBox yard = new HBox();
        yard.setAlignment(Pos.CENTER);

        Shape playground = makeGrid();
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
