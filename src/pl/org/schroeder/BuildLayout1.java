package pl.org.schroeder;

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

import java.util.HashMap;
import java.util.Map;

public class BuildLayout1 {

    Stage stage = new Stage();

    Engine engine;
    Pane discField;
    Board board;

    Map<Integer, Button> buttonList = new HashMap<>();

    public BuildLayout1() {



        buttonList.put(1, new Button("Column One"));
        buttonList.put(2, new Button("Column Two"));
        buttonList.put(3, new Button("Column Three"));
        buttonList.put(4, new Button("Column Four"));
        buttonList.put(5, new Button("Column Five"));
        buttonList.put(6, new Button("Column Six"));
        buttonList.put(7, new Button("Column Seven"));

        this.engine = new Engine(this);
    }

    public void setEventHandlerOnButton(Integer id, EventHandler eventHandler) {
        buttonList.get(id).setOnAction(eventHandler);
    }

    public Shape makeGrid() {
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

    public Circle drawRedDisc(int xP, int yP) {

        Circle redDisc = new Circle(xP, yP, 45);
        redDisc.setFill(Color.RED);

        return redDisc;
    }

    public Circle drawYellowDisc(int xP, int yP) {

        Circle redDisc = new Circle(xP, yP, 45);
        redDisc.setFill(Color.YELLOW);

        return redDisc;
    }

    public void displayStart() {

        board = new Board();


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

        service.getChildren().addAll(buttonList.values());

//        Button button1 = new Button("Column One");
//        button1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 1);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//        Button button2 = new Button("Column Two");
//        button2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 2);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//        Button button3 = new Button("Column Three");
//        button3.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 3);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//        Button button4 = new Button("Column Four");
//        button4.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 4);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//
//        Button button5 = new Button("Column Five");
//        button5.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 5);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//        Button button6 = new Button("Column Six");
//        button6.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 6);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//        Button button7 = new Button("Column Seven");
//        button7.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                board.addChecker(CheckerColor.RED, 7);
//
//                engine.buttonHandling(board, discField);
//            }
//
//        });
//
//        service.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7);
        yard.getChildren().add(playground);
        yard.getChildren().add(discField);
        mainWindow.getChildren().addAll(service, yard);

        Scene scene = new Scene(mainWindow, 705, 640, Color.LIGHTBLUE);

        stage.setTitle("ConnectFour");
        stage.setScene(scene);

        stage.show();
    }

    public void displayEnd() {
        VBox winnerScreen = new VBox();
        Label winInfo = new Label("You win, congratulations! Do you want to play again?");
        winInfo.setFont(new Font(20));
        VBox loserScreen = new VBox();
        Label loseInfo = new Label("Such a shame, you've lost! Do you want to play again?");
        loseInfo.setFont(new Font(20));
        Button again = new Button("YES");
        Button nope = new Button("NO");
        winnerScreen.getChildren().addAll(winInfo, again, nope);
        Scene winnerScene = new Scene(winnerScreen, 500, 400);
        loserScreen.getChildren().addAll(loseInfo, again, nope);
        Scene loserScene = new Scene(loserScreen, 500, 400);
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            stage.setScene(winnerScene);
            stage.show();
        } else if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            stage.setScene(loserScene);
            stage.show();
        }
        again.setOnAction(e -> displayStart());
        nope.setOnAction(e -> System.exit(-1));
    }

    public void placeRedChecker(Board board) {
        int xPosRed = board.getCheckers().get(board.getCheckers().size() - 1).getX();
        int yPosRed = board.getCheckers().get(board.getCheckers().size() - 1).getY();

        int xAxisRed = -640 + ((xPosRed - 1) * 95);
        int yAxisRed = 540 - ((yPosRed - 1) * 95);

        discField.getChildren().add(drawRedDisc(xAxisRed, yAxisRed));
    }

    public void placeYellowChecker(Board board) {
        int xPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getX();
        int yPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getY();

        int xAxisYel = -640 + ((xPosYel - 1) * 95);
        int yAxisYel = 540 - ((yPosYel - 1) * 95);

        discField.getChildren().add(drawYellowDisc(xAxisYel, yAxisYel));
    }

}
