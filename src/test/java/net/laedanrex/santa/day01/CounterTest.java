package net.laedanrex.santa.day01;

import net.laedanrex.santa.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class CounterTest {

    @Test
    void readLine() {
    }

    @Test
    void goLeft_01() {
        Counter counter = new Counter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.goLeft(12));
        counter.goLeft(-12);
        Assertions.assertEquals(38, counter.numberInInterval);
        Assertions.assertEquals(0, counter.hit);
        Assertions.assertEquals(0, counter.numberOfZerosHit);
    }

    @Test
    void goLeft_02() {
        Counter counter = new Counter();
        counter.goLeft(-50);
        Assertions.assertEquals(0, counter.numberInInterval);
        Assertions.assertEquals(1, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
    }

    @Test
    void goLeft_03() {
        Counter counter = new Counter(1);
        counter.goLeft(-1);
        Assertions.assertEquals(0, counter.numberInInterval);
        Assertions.assertEquals(1, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
        counter.goLeft(-1);
        Assertions.assertEquals(99, counter.numberInInterval);
        Assertions.assertEquals(0, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
    }

    @Test
    void goLeft_04() {
        Counter counter = new Counter(0);
        counter.goLeft(-1);
        Assertions.assertEquals(99, counter.numberInInterval);
        Assertions.assertEquals(0, counter.hit);
        Assertions.assertEquals(0, counter.numberOfZerosHit);
    }

    //------------------------------------------------------------------------------------------------------------

    @Test
    void goRight_01() {
        Counter counter = new Counter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.goRight(-12));
        counter.goRight(12);
        Assertions.assertEquals(62, counter.numberInInterval);
        Assertions.assertEquals(0, counter.hit);
        Assertions.assertEquals(0, counter.numberOfZerosHit);
    }

    @Test
    void goRight_02() {
        Counter counter = new Counter();
        counter.goRight(49);
        Assertions.assertEquals(99, counter.numberInInterval);
        Assertions.assertEquals(0, counter.hit);
        Assertions.assertEquals(0, counter.numberOfZerosHit);
    }

    @Test
    void goRight_03() {
        Counter counter = new Counter();
        counter.goRight(50);
        Assertions.assertEquals(0, counter.numberInInterval);
        Assertions.assertEquals(1, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
        counter.goRight(1);
        Assertions.assertEquals(1, counter.numberInInterval);
        Assertions.assertEquals(0, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
    }

    @Test
    void goRight_04() {
        Counter counter = new Counter(50);
        counter.goRight(149);
        Assertions.assertEquals(99, counter.numberInInterval);
        Assertions.assertEquals(1, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
    }

    @Test
    void goRight_05() {
        Counter counter = new Counter();
        counter.goRight(150);
        Assertions.assertEquals(0, counter.numberInInterval);
        Assertions.assertEquals(2, counter.hit);
        Assertions.assertEquals(2, counter.numberOfZerosHit);
    }
    @Test
    void goRight_06() {
        Counter counter = new Counter(95);
        counter.goRight(60);
        Assertions.assertEquals(55, counter.numberInInterval);
        Assertions.assertEquals(1, counter.hit);
        Assertions.assertEquals(1, counter.numberOfZerosHit);
    }

    @Test
    void getNumber() {
        Counter counter = new Counter();
        Assertions.assertEquals(15, counter.getNumber("R15"));
        Assertions.assertEquals(-12, counter.getNumber("L12"));
        Assertions.assertEquals(0, counter.getNumber("L0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.getNumber("L-1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> counter.getNumber("R-1"));
    }

    @Test
    void testComplet() throws Exception {
        Counter counter = new Counter(50);

        counter.printHeader();
        Files.lines(ResourcesUtils.getResourcePath("day01/input_2_test"))
                .forEach(line -> {
                    counter.readLine(line);
                    counter.print();
                });
    }

}