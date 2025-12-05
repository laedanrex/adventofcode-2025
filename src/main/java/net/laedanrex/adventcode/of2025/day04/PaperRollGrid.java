package net.laedanrex.adventcode.of2025.day04;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PaperRollGrid {

    private static final Character ROLL = '@';
    private static final Character ROLL_MARKED = 'x';
    private static final Character EMPTY = '.';
    private final int maxRollsAround;
    @Getter
    List<List<Character>> grid = new ArrayList<>();
    int maxX = 0;
    int maxY = 0;
    @Getter
    public int totalRollMarked = 0;
    public int totalRollRemoved = 0;

    public PaperRollGrid() {
        this(4);
    }

    public PaperRollGrid(int maxRollsAround) {
        this.maxRollsAround = maxRollsAround;
    }

    public void addLine(String lineString) {

        List<Character> line = new ArrayList<>(lineString.length());
        lineString.chars().forEach(e -> line.add((char) e));

        grid.add(line);
        maxX = line.size() - 1;
        maxY = grid.size() - 1;
    }

    boolean isRoll(int y, int x) {
        return isRoll(grid.get(y).get(x));
    }

    boolean isRoll(Character character) {
        return character.equals(ROLL) || character.equals(ROLL_MARKED);
    }

    boolean isAccessibleRoll(Character character) {
        return character.equals(ROLL_MARKED);
    }

    public int markAccessibleRolls() {
        int marked = 0;
        for (int y = 0; y < grid.size(); y++) {
            List<Character> line = grid.get(y);

            for (int x = 0; x < line.size(); x++) {
                if (isRoll(line.get(x)) && numberOfRollsAround(y, x) < maxRollsAround) {
                    markAccessible(x, y);
                    marked++;
                }
            }
        }
        return marked;
    }

    public int removeAccessibleRolls() {
        int removed = 0;
        for (int y = 0; y < grid.size(); y++) {
            List<Character> line = grid.get(y);

            for (int x = 0; x < line.size(); x++) {
                if (isAccessibleRoll(line.get(x))) {
                    markRemoved(x, y);
                    removed++;
                }
            }
        }
        return removed;
    }

    private void markAccessible(int x, int y) {
        grid.get(y).set(x, ROLL_MARKED);
        totalRollMarked++;
    }

    private void markRemoved(int x, int y) {
        grid.get(y).set(x, EMPTY);
        totalRollRemoved++;
    }

    private int numberOfRollsAround(int y, int x) {
        int by = y - 1;
        int ay = y + 1;
        int bx = x - 1;
        int ax = x + 1;
        boolean BY = by >= 0;
        boolean AY = ay <= maxY;
        boolean BX = bx >= 0;
        boolean AX = ax <= maxX;
        int counter = 0;
        //  BY+BX | BY+X | BY+AX
        //   Y+BX |   0  |  Y+AX
        //  AY+BX | AY+X | AY+AX
        if (BY && BX && isRoll(by, bx)) counter++;
        if (BY && isRoll(by, x)) counter++;
        if (BY && AX && isRoll(by, ax)) counter++;
        //----
        if (BX && isRoll(y, bx)) counter++;
        //middle
        if (AX && isRoll(y, ax)) counter++;
        //----
        if (AY && BX && isRoll(ay, bx)) counter++;
        if (AY && isRoll(ay, x)) counter++;
        if (AY && AX && isRoll(ay, ax)) counter++;

        return counter;
    }

    @Override
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        grid.forEach(
                line -> {
                    line.forEach(sb2::append);
                    sb2.append('\n');
                }
        );
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }
}
