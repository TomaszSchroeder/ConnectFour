package pl.org.schroeder;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class Engine {

    Layout.BuildLayout buildLayout;
    Board board;
    Layout layout;
    Engine engine;

    public Engine() {

    }


    public void buttonHandling(Board board, Pane discField) {
        placeRedChecker(board, discField);

        checkRedWinner(board);

        waitAsecond();

        board.compMove(CheckerColor.YELLOW);

        placeYellowChecker(board, discField);

        checkYellowWinner(board);

        Platform.runLater(() -> afterTurns(board));
    }

    public void checkRedWinner(Board board) {
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            System.out.println("Red Wins");
//            wait3sec();
//            Main.displayWin();
        }

    }


    public void checkYellowWinner(Board board) {
        if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            System.out.println("Yellow Wins");
//            wait3sec();
//            Main.displayLose();
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

        discField.getChildren().add(Layout.BuildLayout.drawRedDisc(xAxisRed, yAxisRed, 45));
    }

    public void placeYellowChecker(Board board, Pane discField) {
        int xPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getX();
        int yPosYel = board.getCheckers().get(board.getCheckers().size() - 1).getY();

        int xAxisYel = -640 + ((xPosYel - 1) * 95);
        int yAxisYel = 540 - ((yPosYel - 1) * 95);

        discField.getChildren().add(Layout.BuildLayout.drawYellowDisc(xAxisYel, yAxisYel, 45));
    }

    public void afterTurns(Board board) {
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            System.out.println("Red Wins");
            wait3sec();
            buildLayout.displayWin();
        } else if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            System.out.println("Yellow Wins");
            wait3sec();
            buildLayout.displayLose();
        }
    }
}
