package net.laedanrex.adventcode.of2025.day06;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class CephalopodCalculatorTest {

    @Test
    void addLine() throws Exception {
        CephalopodCalculator calc = new CephalopodCalculator();
        Files.lines(ResourcesUtils.getResourcePath("day06/input_01_test"))
                .forEach(calc::addLine);

        System.out.println(calc.grid);
    }

    @Test
    void calculateColumn() throws Exception {
        CephalopodCalculator calc = new CephalopodCalculator();
        Files.lines(ResourcesUtils.getResourcePath("day06/input_01_test"))
                .forEach(calc::addLine);

        Assertions.assertEquals(33210, calc.calculateColumn(0));
        Assertions.assertEquals(490, calc.calculateColumn(1));
        Assertions.assertEquals(4243455, calc.calculateColumn(2));
        Assertions.assertEquals(401, calc.calculateColumn(3));
    }

    @Test
    void calculateGrandTotal() throws Exception {
        CephalopodCalculator calc = new CephalopodCalculator();
        Files.lines(ResourcesUtils.getResourcePath("day06/input_01_test"))
                .forEach(calc::addLine);

        Assertions.assertEquals(4277556, calc.calculateGrandTotal());
    }

    @Test
    void calculateGrandTotalRightToLeft() throws Exception {
        CephalopodCalculator calc = new CephalopodCalculator();
        Files.lines(ResourcesUtils.getResourcePath("day06/input_01_test"))
                .forEach(calc::addLine);

        Assertions.assertEquals(3263827, calc.calculateGrandTotalRightToLeft());
    }
}