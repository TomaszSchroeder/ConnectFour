package pl.org.schroeder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    private ArrayList<Checker> checkers = new ArrayList<>();

    public Board() {
        checkers.addAll(Arrays.asList(
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
                    return true;
                }
            }
        }
        return false;
    }

    // badanie osi ukośnych
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
                    win1 &= checkers.stream().filter(c -> c.getColor().equals(color)).filter(c -> c.getX().equals(finalW + finalDelta)).filter(c -> c.getY().equals(finalH + finalDelta)).findAny().isPresent();
                    win2 &= checkers.stream().filter(c -> c.getColor().equals(color)).filter(c -> c.getX().equals(finalW + finalDelta)).filter(c -> c.getY().equals(finalH - finalDelta)).findAny().isPresent();
                    win3 &= checkers.stream().filter(c -> c.getColor().equals(color)).filter(c -> c.getX().equals(finalW - finalDelta)).filter(c -> c.getY().equals(finalH + finalDelta)).findAny().isPresent();
                    win4 &= checkers.stream().filter(c -> c.getColor().equals(color)).filter(c -> c.getX().equals(finalW - finalDelta)).filter(c -> c.getY().equals(finalH - finalDelta)).findAny().isPresent();
                }

                if (win1 || win2 || win3 || win4) {
                    return true;
                }
            }
        }
        return false;
    }


    // Human adding a checker
    public Boolean addChecker(String color, Integer xCord) {

        if (checkers.stream().filter(c -> c.getX().equals(xCord)).findAny().isPresent()) {
            Integer yCord = checkers.stream().filter(c -> c.getX().equals(xCord)).mapToInt(c -> c.getY()).max().getAsInt();

            checkers.add(new Checker(xCord, yCord + 1, color));

        } else {

            checkers.add(new Checker(xCord, 1, color));
        }

        return true;
    }

    // Computer adding a checker
    public Boolean compMove(String color) {

        int xCordComp = randomNumber(1, 7);

        if (checkers.stream().filter(c -> c.getX().equals(xCordComp)).findAny().isPresent()) {
            Integer yCord = checkers.stream().filter(c -> c.getX().equals(xCordComp)).mapToInt(c -> c.getY()).max().getAsInt();
            checkers.add(new Checker(xCordComp, yCord + 1, "Yellow"));
        } else {

            checkers.add(new Checker(xCordComp, 1, "Yellow"));
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