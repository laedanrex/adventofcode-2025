package net.laedanrex.adventcode.of2025;

import net.laedanrex.adventcode.of2025.day01.SafeClicCounter;
import net.laedanrex.adventcode.of2025.day02.InvalidIDRangesContainer;
import net.laedanrex.adventcode.of2025.day03.BatteriesBanks;
import net.laedanrex.adventcode.of2025.day04.PaperRollGrid;
import net.laedanrex.adventcode.of2025.day05.FreshIDRangesContainer;
import net.laedanrex.adventcode.of2025.day06.CephalopodCalculator;

import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws Exception {
        day06();
    }

    static void day06() throws Exception {
        CephalopodCalculator calc = new CephalopodCalculator();
        Files.lines(ResourcesUtils.getResourcePath("day06/input_01"))
                .forEach(calc::addLine);

        // System.out.println(calc.calculateGrandTotal());
        System.out.println(calc.calculateGrandTotalRightToLeft());
    }

    static void day05() throws Exception {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day05/input_01"))
                .forEach(container::addFreshRangeOrID);
        List<Long> freshIDs = container.getFreshIDs();
        List<Long> spoilIDs = container.getSpoilIDs();

        System.out.println(freshIDs);
        System.out.println(spoilIDs);
        System.out.println("FRESH " + freshIDs.size());
        System.out.println("SPOIL " + spoilIDs.size());

        // System.out.println("POSSIBLE FRESH " +container.getPossibleFreshIDs().size());
        // OutOfMemoryError: Java heap space

        container.mergeFreshRanges();
        System.out.println(container.getNumberOfPossibleFreshIDs());
    }

    static void day04() throws Exception {
        PaperRollGrid paperRollGrid = new PaperRollGrid();
        Files.lines(ResourcesUtils.getResourcePath("day04/input_01"))
                .forEach(paperRollGrid::addLine);
        do {
            paperRollGrid.markAccessibleRolls();
        } while (paperRollGrid.removeAccessibleRolls() > 0);
        System.out.println(paperRollGrid.totalRollMarked);
    }

    static void day03() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(12);
        Files.lines(ResourcesUtils.getResourcePath("day03/input_01"))
                .forEach(batteriesBanks::addBatteries);

        System.out.println(batteriesBanks.getBestJoltageSum());
    }

    static void day02() throws Exception {
        InvalidIDRangesContainer validator = new InvalidIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day02/input_01"))
                .forEach(validator::addRanges);
        validator.printAllInvalidIDS();
        System.out.println("==========================");
        System.out.println(validator.sumOfAllInvalid());
    }

    static void day01() throws Exception {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        safeClicCounter.printHeader();
        Files.lines(ResourcesUtils.getResourcePath("day01/input_2"))
                .forEach(line -> {
                    safeClicCounter.readLine(line);
                    safeClicCounter.print();
                });
        safeClicCounter.printHeader();
        System.out.println(LocalDateTime.now());
    }

}
