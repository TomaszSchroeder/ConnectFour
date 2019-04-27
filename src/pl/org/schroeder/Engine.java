package com.kodilla.connect4;

import javafx.scene.layout.Pane;

import static com.kodilla.connect4.Main.displayLose;
import static com.kodilla.connect4.Main.displayWin;

public class Engine {

    Layout layout;

    public Engine() {

    }

    public void buttonHandling(Board board, Pane discField) {
        placeRedChecker(board, discField);

        checkRedWinner(board);

        waitAsecond();

        board.compMove(CheckerColor.YELLOW);

        placeYellowChecker(board, discField);

        checkYellowWinner(board);
    }

    public void checkRedWinner(Board board) {
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            System.out.println("Red Wins");
            wait3sec();
            displayWin();
        }

    }


    public void checkYellowWinner(Board board) {
        if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            System.out.println("Yellow Wins");
            wait3sec();
            displayLose();
        }
    }

    public void waitAsecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void wait3sec() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void placeRedChecker(Board board, Pane discField) {
        int xPosRed = board.getCheckers().get(board.getCheckers().size() - 1).getX();
        int yPosRed = board.getCheckers().get(board.getCheckers().size() - 1).getY();

        int xAxisRed = -640 + ((xPosRed - 1) * 95);
        int yAxisRed = 540 - ((yPosRed - 1) * 95);

        discField.getChildren().add(layout.drawRedDisc(xAxisRed, yAxisRed, 45));
    }

    public void placeYellowChecker(Board board, Pane discField) {
        int xPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getX();
        int yPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getY();

        int xAxisYel = -640 + ((xPosYel - 1) * 95);
        int yAxisYel = 540 - ((yPosYel - 1) * 95);

        discField.getChildren().add(layout.drawYellowDisc(xAxisYel, yAxisYel, 45));
    }


}
