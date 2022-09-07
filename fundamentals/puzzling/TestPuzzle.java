import java.util.Random;
import java.util.ArrayList;

public class TestPuzzle {
    public static void main (String[] args) {
        PuzzleJava puzzle = new PuzzleJava();
        ArrayList<Integer> randomRolls = puzzle.getTenRolls();
        System.out.println(randomRolls);

        System.out.println(puzzle.getRandomLetter());
        System.out.println(puzzle.getRandomLetterWithArray());
        System.out.println(puzzle.generatePassword());
        System.out.println(puzzle.getNewPasswordSet(7));
    }
}
