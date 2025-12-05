package net.laedanrex.adventcode.of2025.day02;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.List;

class InvalidIDRangeTest {
    @BeforeAll
    public static void beforeAll() {
        // Setting the logging level to OFF for specific tests
        // NO Logger.getLogger(RangeTest.class.getName()).setLevel(Level.FINEST);
        // NO Logger.getLogger(Range.class.getName()).setLevel(Level.FINEST);
    }

    @BeforeEach
    public void beforeEach() {
        // Setting the logging level to OFF for specific tests
        // NO Logger.getLogger(RangeTest.class.getName()).setLevel(Level.FINEST);
        // NO Logger.getLogger(Range.class.getName()).setLevel(Level.FINEST);
    }

    @Test
    void getInvalidIDS_01() {
        InvalidIDRange range = new InvalidIDRange("11-22");
        Assertions.assertEquals(List.of("11", "22"), range.getInvalidIDS());
    }

    @Test
    void getInvalidIDS_02() {
        InvalidIDRange invalidIDRange = new InvalidIDRange("111-222");
        Assertions.assertEquals(List.of("111", "222"), invalidIDRange.getInvalidIDS());
    }

    @Test
    void getInvalidIDS_03() {
        InvalidIDRange invalidIDRange = new InvalidIDRange("1111-2222");
        Assertions.assertEquals(List.of("1111", "1212", "1313", "1414", "1515", "1616", "1717", "1818", "1919", "2020", "2121", "2222"), invalidIDRange.getInvalidIDS());
    }

    @Test
    void getInvalidIDS_04() {
        InvalidIDRange invalidIDRange = new InvalidIDRange("998-1012");
        Assertions.assertEquals(List.of("999", "1010"), invalidIDRange.getInvalidIDS());
    }

    @Test
    void test_complet() throws Exception {
        InvalidIDRangesContainer invalidIDRangesContainer = new InvalidIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day02/input_01_test"))
                .forEach(invalidIDRangesContainer::addRanges);
        invalidIDRangesContainer.printAllInvalidIDS();
        System.out.println("---");
        invalidIDRangesContainer.printSumOfAllInvalid();
    }
}