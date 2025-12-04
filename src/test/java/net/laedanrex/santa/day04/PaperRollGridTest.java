package net.laedanrex.santa.day04;

import net.laedanrex.santa.ResourcesUtils;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PaperRollGridTest {

    @Test
    void addLine() {
        PaperRollGrid paperRollGrid = new PaperRollGrid();
        paperRollGrid.addLine("..@@.@@@@.");
        assertIterableEquals(Arrays.asList(new Character[]{'.', '.', '@', '@', '.', '@', '@', '@', '@', '.'}), paperRollGrid.grid.get(0));
    }

    @Test
    void isRoll() {
        PaperRollGrid paperRollGrid = new PaperRollGrid();
        paperRollGrid.addLine("..@@.@@@@.");
        assertFalse(paperRollGrid.isRoll(0, 1));
        assertTrue(paperRollGrid.isRoll(0, 2));
    }

    @Test
    void testIsRoll() {
    }

    @Test
    void markAccessibleRolls() throws Exception {
        PaperRollGrid paperRollGrid = new PaperRollGrid();
        Files.lines(ResourcesUtils.getResourcePath("day04/input_01_test"))
                .forEach(paperRollGrid::addLine);
        paperRollGrid.markAccessibleRolls();
        System.out.println(paperRollGrid);
        String str1 = ResourcesUtils.getResourceString("day04/output_01_test").replaceAll("\r", "");
        String str2 = paperRollGrid.toString();
        assertEquals(str1, str2);
        assertEquals(13, paperRollGrid.totalRollMarked);
    }

    @Test
    void markAccessibleRollsManyTime() throws Exception {
        PaperRollGrid paperRollGrid = new PaperRollGrid();
        Files.lines(ResourcesUtils.getResourcePath("day04/input_01_test"))
                .forEach(paperRollGrid::addLine);

        assertEquals(13, paperRollGrid.markAccessibleRolls());
        assertEquals(13, paperRollGrid.removeAccessibleRolls());
        assertEquals(13, paperRollGrid.totalRollMarked);
        assertEquals(13, paperRollGrid.totalRollRemoved);

        assertEquals(12, paperRollGrid.markAccessibleRolls());
        assertEquals(12, paperRollGrid.removeAccessibleRolls());
        assertEquals(25, paperRollGrid.totalRollMarked);
        assertEquals(25, paperRollGrid.totalRollRemoved);

        assertEquals(7, paperRollGrid.markAccessibleRolls());
        assertEquals(7, paperRollGrid.removeAccessibleRolls());
        assertEquals(32, paperRollGrid.totalRollMarked);
        assertEquals(32, paperRollGrid.totalRollRemoved);

        assertEquals(5, paperRollGrid.markAccessibleRolls());
        assertEquals(5, paperRollGrid.removeAccessibleRolls());
        assertEquals(37, paperRollGrid.totalRollMarked);
        assertEquals(37, paperRollGrid.totalRollRemoved);
    }

    @Test
    void markAccessibleRollsLoop() throws Exception {
        PaperRollGrid paperRollGrid = new PaperRollGrid();
        Files.lines(ResourcesUtils.getResourcePath("day04/input_01_test"))
                .forEach(paperRollGrid::addLine);

        do {
            paperRollGrid.markAccessibleRolls();
        } while (paperRollGrid.removeAccessibleRolls() > 0);

        assertEquals(43, paperRollGrid.totalRollMarked);
        assertEquals(43, paperRollGrid.totalRollRemoved);

    }

}