package pl.org.schroeder;

public class Engine {

    BuildLayout buildLayout;
    Board board = new Board();

    public Engine() {
        this.buildLayout = new BuildLayout(board);

        for (int i = 1; i < 8; i++) {
            int finalI = i;
            buildLayout.setEventHandlerOnButton(i, event -> {
                board.addChecker(CheckerColor.RED, finalI);
                buttonHandling(board, finalI);
            });
        }
        buildLayout.displayStart();
    }

    public void buttonHandling(Board board, Integer i) {

        if (Validators.getAvailableColumns().contains(i)) {

            buildLayout.placeRedChecker(board);

            if (checkWinner(board) == true) {
                buildLayout.displayEndForWinnerPlayer();
            } else {

                board.compMove(CheckerColor.YELLOW);
                buildLayout.placeYellowChecker(board);
                if (checkWinner(board) == true) {
                    buildLayout.displayEndForWinnerCPU();
                }
            }
        }
    }

    public boolean checkWinner(Board board) {
        if ((board.checkWinningCondition("Red")) || (board.checkWinningCondition2("Red")) || (board.checkWinningCondition3("Red"))) {
            System.out.println("Red Wins");
            buildLayout.displayEndForWinnerPlayer();
            return true;
        } else if ((board.checkWinningCondition("Yellow")) || (board.checkWinningCondition2("Yellow")) || (board.checkWinningCondition3("Yellow"))) {
            System.out.println("Yellow Wins");
            buildLayout.displayEndForWinnerCPU();
            return true;
        }
        return false;
    }
}
