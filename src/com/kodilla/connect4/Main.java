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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main extends Application {

    private Shape makeGrid() {
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
        Pane discField = new Pane();
        discField.setMaxSize(705, 610);

        Board board = new Board();


        Button button1 = new Button("Column One");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 1);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });

        Button button2 = new Button("Column Two");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 2);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });

        Button button3 = new Button("Column Three");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 3);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });

        Button button4 = new Button("Column Four");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 4);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });

        Button button5 = new Button("Column Five");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 5);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });

        Button button6 = new Button("Column Six");
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 6);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });

        Button button7 = new Button("Column Seven");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                board.addChecker(CheckerColor.RED, 7);

                placeRedChecker(board, discField);

                checkRedWinner(board);

                waitAsecond();

                board.compMove(CheckerColor.YELLOW);

                placeYellowChecker(board, discField);

                checkYellowWinner(board);
            }

        });


//        Button button11 = new Button("Print Board");
//        button11.setOnAction((event -> {
//            System.out.println(board);
//        }));
//
//        Button button12 = new Button("White Wins?");
//        button11.setOnAction((event -> {
//            board.checkWinningCondition("White");
//        }));

        service.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7);
//        starters.getChildren().addAll(button11, button12);
        yard.getChildren().add(playground);
        yard.getChildren().add(discField);
        mainWindow.getChildren().addAll(service, yard);

        Scene scene = new Scene(mainWindow, 705, 640, Color.LIGHTBLUE);

        primaryStage.setTitle("ConnectFour");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void checkRedWinner(Board board) {
        board.checkWinningCondition("Red");
        board.checkWinningCondition2("Red");
        board.checkWinningCondition3("Red");
    }

    public void checkYellowWinner(Board board) {
        board.checkWinningCondition("Red");
        board.checkWinningCondition2("Red");
        board.checkWinningCondition3("Red");
    }

    public void waitAsecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void placeRedChecker(Board board, Pane discField) {
        int xPosRed = board.getCheckers().get(board.getCheckers().size()-1).getX();
        int yPosRed = board.getCheckers().get(board.getCheckers().size()-1).getY();

        int xAxisRed = -640 + ((xPosRed - 1) * 95);
        int yAxisRed = 540 - ((yPosRed - 1) * 95);

        discField.getChildren().add(drawRedDisc(xAxisRed, yAxisRed, 45));
    }

    public void placeYellowChecker(Board board, Pane discField) {
        int xPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getX();
        int yPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getY();

        int xAxisYel = -640 + ((xPosYel - 1) * 95);
        int yAxisYel = 540 - ((yPosYel - 1) * 95);

        discField.getChildren().add(drawYellowDisc(xAxisYel, yAxisYel, 45));
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

    public ArrayList<Checker> getCheckers() {
        return checkers;
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
                if (counter == 4) {
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
                if (counter == 4) {
                    System.out.println(color + " Wins");
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean checkWinningCondition3(String color) {

        final int WIDTH = 7;
        final int HEIGHT = 6;

        for (int w = 1; w < WIDTH; w++) {
            for (int h = 1; h < HEIGHT; h++) {

                Boolean win1 = true;
                Boolean win2 = true;
                Boolean win3 = true;
                Boolean win4 = true;

                int finalW = w;
                int finalH = h;
                for (int delta = 0; delta < 4; delta++) {
                    int finalDelta = delta;
                    win1 &= checkers.stream().filter(c->c.getColor().equals(color)).filter(c -> c.getX().equals(finalW + finalDelta)).filter(c -> c.getY().equals(finalH + finalDelta)).findAny().isPresent();
                    win2 &= checkers.stream().filter(c->c.getColor().equals(color)).filter(c -> c.getX().equals(finalW + finalDelta)).filter(c -> c.getY().equals(finalH - finalDelta)).findAny().isPresent();
                    win3 &= checkers.stream().filter(c->c.getColor().equals(color)).filter(c -> c.getX().equals(finalW - finalDelta)).filter(c -> c.getY().equals(finalH + finalDelta)).findAny().isPresent();
                    win4 &= checkers.stream().filter(c->c.getColor().equals(color)).filter(c -> c.getX().equals(finalW - finalDelta)).filter(c -> c.getY().equals(finalH - finalDelta)).findAny().isPresent();
                }

                if (win1 || win2 || win3 || win4) {
                    System.out.println(color + " Wins");
                    return true;
                }

            }
        }
        return false;
    }




    // Human adding a checker
    public Boolean addChecker(String color, Integer xCord) {
        if(checkers.stream().filter(c -> c.getX().equals(xCord)).findAny().isPresent()){
                  Integer yCord= checkers.stream().filter(c -> c.getX().equals(xCord)).mapToInt(c->c.getY()).max().getAsInt();
                  checkers.add(new Checker(xCord, yCord + 1, color));

        } else {

            checkers.add(new Checker(xCord,  1, color));

        }

        return true;
    }

    // Computer adding a checker
    public Boolean compMove(String color) {

        int xCordComp = randomNumber(1, 7);

        if(checkers.stream().filter(c->c.getX().equals(xCordComp)).findAny().isPresent()){
            Integer yCord = checkers.stream().filter(c->c.getX().equals(xCordComp)).mapToInt(c->c.getY()).max().getAsInt();
            checkers.add(new Checker(xCordComp, yCord + 1, "Yellow" ));
        } else {

        checkers.add(new Checker(xCordComp,1, "Yellow" ));
        }
        return true;
    }


    @Override
    public String toString() {
        return "Board{" +
                "checkers=" + checkers +
                '}';
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }



}

