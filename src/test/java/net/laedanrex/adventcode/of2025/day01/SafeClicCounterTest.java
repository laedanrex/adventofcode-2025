package net.laedanrex.adventcode.of2025.day01;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class SafeClicCounterTest {

    @Test
    void readLine() {
    }

    @Test
    void goLeft_01() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> safeClicCounter.goLeft(12));
        safeClicCounter.goLeft(-12);
        Assertions.assertEquals(38, safeClicCounter.numberInInterval);
        Assertions.assertEquals(0, safeClicCounter.hit);
        Assertions.assertEquals(0, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goLeft_02() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        safeClicCounter.goLeft(-50);
        Assertions.assertEquals(0, safeClicCounter.numberInInterval);
        Assertions.assertEquals(1, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goLeft_03() {
        SafeClicCounter safeClicCounter = new SafeClicCounter(1);
        safeClicCounter.goLeft(-1);
        Assertions.assertEquals(0, safeClicCounter.numberInInterval);
        Assertions.assertEquals(1, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
        safeClicCounter.goLeft(-1);
        Assertions.assertEquals(99, safeClicCounter.numberInInterval);
        Assertions.assertEquals(0, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goLeft_04() {
        SafeClicCounter safeClicCounter = new SafeClicCounter(0);
        safeClicCounter.goLeft(-1);
        Assertions.assertEquals(99, safeClicCounter.numberInInterval);
        Assertions.assertEquals(0, safeClicCounter.hit);
        Assertions.assertEquals(0, safeClicCounter.numberOfZerosHit);
    }

    //------------------------------------------------------------------------------------------------------------

    @Test
    void goRight_01() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> safeClicCounter.goRight(-12));
        safeClicCounter.goRight(12);
        Assertions.assertEquals(62, safeClicCounter.numberInInterval);
        Assertions.assertEquals(0, safeClicCounter.hit);
        Assertions.assertEquals(0, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goRight_02() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        safeClicCounter.goRight(49);
        Assertions.assertEquals(99, safeClicCounter.numberInInterval);
        Assertions.assertEquals(0, safeClicCounter.hit);
        Assertions.assertEquals(0, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goRight_03() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        safeClicCounter.goRight(50);
        Assertions.assertEquals(0, safeClicCounter.numberInInterval);
        Assertions.assertEquals(1, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
        safeClicCounter.goRight(1);
        Assertions.assertEquals(1, safeClicCounter.numberInInterval);
        Assertions.assertEquals(0, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goRight_04() {
        SafeClicCounter safeClicCounter = new SafeClicCounter(50);
        safeClicCounter.goRight(149);
        Assertions.assertEquals(99, safeClicCounter.numberInInterval);
        Assertions.assertEquals(1, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void goRight_05() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        safeClicCounter.goRight(150);
        Assertions.assertEquals(0, safeClicCounter.numberInInterval);
        Assertions.assertEquals(2, safeClicCounter.hit);
        Assertions.assertEquals(2, safeClicCounter.numberOfZerosHit);
    }
    @Test
    void goRight_06() {
        SafeClicCounter safeClicCounter = new SafeClicCounter(95);
        safeClicCounter.goRight(60);
        Assertions.assertEquals(55, safeClicCounter.numberInInterval);
        Assertions.assertEquals(1, safeClicCounter.hit);
        Assertions.assertEquals(1, safeClicCounter.numberOfZerosHit);
    }

    @Test
    void getNumber() {
        SafeClicCounter safeClicCounter = new SafeClicCounter();
        Assertions.assertEquals(15, safeClicCounter.getNumber("R15"));
        Assertions.assertEquals(-12, safeClicCounter.getNumber("L12"));
        Assertions.assertEquals(0, safeClicCounter.getNumber("L0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> safeClicCounter.getNumber("L-1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> safeClicCounter.getNumber("R-1"));
    }

    @Test
    void testComplet() throws Exception {
        SafeClicCounter safeClicCounter = new SafeClicCounter(50);

        safeClicCounter.printHeader();
        Files.lines(ResourcesUtils.getResourcePath("day01/input_2_test"))
                .forEach(line -> {
                    safeClicCounter.readLine(line);
                    safeClicCounter.print();
                });
    }

}