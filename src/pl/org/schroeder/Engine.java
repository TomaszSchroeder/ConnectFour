package pl.org.schroeder;

import javafx.application.Platform;

public class Engine {

    BuildLayout1 buildLayout1;
    Board board = new Board();

    public Engine(BuildLayout1 buildLayout1) {
        this.buildLayout1 = buildLayout1;

        for(int i=1; i<8; i++) {
            int finalI = i;
            buildLayout1.setEventHandlerOnButton(i, event -> {
                board.addChecker(CheckerColor.RED, finalI);
                buttonHandling(board);
            });
        }
    }

    public void buttonHandling(Board board) {
        buildLayout1.placeRedChecker(board);

        checkRedWinner(board);

        board.compMove(CheckerColor.YELLOW);

        buildLayout1.placeYellowChecker(board);

        checkYellowWinner(board);

        Platform.runLater(() -> afterTurns(board));
    }

    public void checkRedWinner(Board board) {
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            System.out.println("Red Wins");
        }
    }

    public void checkYellowWinner(Board board) {
        if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            System.out.println("Yellow Wins");
        }
    }


    public void afterTurns(Board board) {
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            System.out.println("Red Wins");
            buildLayout1.displayEnd();
        } else if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            System.out.println("Yellow Wins");
            buildLayout1.displayEnd();
        }
    }
}
