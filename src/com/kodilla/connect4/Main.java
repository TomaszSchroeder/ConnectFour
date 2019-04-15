package com.kodilla.connect4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main extends Application {

    private Shape makeGrid() {
        Shape shape = new Rectangle(710, 620);

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

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {


//
        VBox mainWindow = new VBox(5);
        HBox starters = new HBox(5);
        starters.setAlignment(Pos.CENTER);
        HBox service = new HBox(10);
        service.setAlignment(Pos.CENTER);
        HBox yard = new HBox();
        yard.setAlignment(Pos.CENTER);

        Shape playground = makeGrid();

        Board board = new Board();

//        board.addChecker("Red", 1);
//        board.compMove("Yellow");
//        board.addChecker("Red", 1);
//        board.compMove("Yellow");

        Button button1 = new Button("Column One");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 1);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                board.compMove(CheckerColor.YELLOW);
            }
        });

        Button button2 = new Button("Column Two");
        button2.setOnAction((event -> {
            board.addChecker("White", 2);
        }));

        Button button3 = new Button("Column Three");
        button3.setOnAction((event -> {
            board.addChecker("White", 3);
        }));

        Button button4 = new Button("Column Four");
        button4.setOnAction((event -> {
            board.addChecker("White", 4);
        }));

        Button button5 = new Button("Column Five");
        button5.setOnAction((event -> {
            board.addChecker("White", 5);
        }));

        Button button6 = new Button("Column Six");
        button5.setOnAction((event -> {
            board.addChecker("White", 6);
        }));

        Button button7 = new Button("Column Seven");
        button5.setOnAction((event -> {
            board.addChecker("White", 7);
        }));


        Button button11 = new Button("Print Board");
        button11.setOnAction((event -> {
            System.out.println(board);
        }));

        Button button12 = new Button("White Wins?");
        button11.setOnAction((event -> {
            board.checkWinningCondition("White");
        }));

        service.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7);
        starters.getChildren().addAll(button11, button12);
        yard.getChildren().add(playground);
        mainWindow.getChildren().addAll(starters, service, yard);

        Scene scene = new Scene(mainWindow, 900, 700, Color.LIGHTBLUE);

        primaryStage.setTitle("ConnectFour");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

class Checker {
    private Integer x, y;
    private String color;

    public Checker(Integer x, Integer y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Checker{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}';
    }
}

class CheckerColor {

    public static final String RED = "Red";
    public static final String YELLOW = "Yellow";

}

class Board {

    private ArrayList<Checker> checkers = new ArrayList<>();

    public Board() {
        checkers.addAll(Arrays.asList(
//                new Checker(1, 1, Color.RED),
//                new Checker(2, 1, Color.YELLOW),
//                new Checker(3, 1, Color.RED),
//                new Checker(4, 1, Color.YELLOW),
//                new Checker(1, 2, Color.YELLOW),
//                new Checker(3, 2, Color.RED),
//                new Checker(4, 2, Color.YELLOW)

        ));
    }

    // badanie ukladu osi Y
    public Boolean checkWinningCondition(String color) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {


                int finalI = i;
                int finalJ = j;
                Long counter = checkers.stream()
                        .filter(c -> c.getY().equals(finalI))
                        .filter(checker -> checker.getColor().equals(color))
                        .filter(checker -> IntStream.range(finalJ, finalJ + 4).boxed().collect(Collectors.toList()).contains(checker.getX()))
                        .count();
                if (counter == 3) {
                    System.out.println(color + " Wins!");
                    return true;

                }
            }
        }
        return false;
    }

    // badanie układu osi X
    public Boolean checkWinningCondition2(String color) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {

                int finalI = i;
                int finalJ = j;
                Long counter = checkers.stream().
                        filter(c -> c.getX().equals(finalI))
                        .filter(checker -> checker.getColor().equals(color))
                        .filter(checker -> IntStream.range(finalJ, finalJ + 4).boxed().collect(Collectors.toList()).contains(checker.getY()))
                        .count();
                if (counter == 3) {
                    System.out.println(color + " Wins");
                    return true;
                }
            }
        }
        return false;
    }


    // Human adding a checker
    public Boolean addChecker(String color, Integer xCord) {
        Integer yCord = checkers.stream().filter(c -> c.getX().equals(xCord)).mapToInt(c -> c.getY()).max().getAsInt();
        checkers.add(new Checker(xCord, yCord + 1, color));

        return true;
    }

    // Computer adding a checker
    public Boolean compMove(String color) {
        Random random = new Random((7) + 1);

        Integer yCord = checkers.stream().filter(c -> c.getX().equals(random)).mapToInt(c -> c.getY()).max().getAsInt();
        checkers.add(new Checker(random.nextInt(), yCord + 1, color));

        return true;
    }


    @Override
    public String toString() {
        return "Board{" +
                "checkers=" + checkers +
                '}';
    }

}
