package net.laedanrex.santa.day03;

import net.laedanrex.santa.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

class BanksTest {

    @Test
    void addBatteries() throws Exception {
        Banks banks = new Banks(12);
        Files.lines(ResourcesUtils.getResourcePath("day03/input_01_test"))
                .forEach(banks::addBatteries);

        Assertions.assertEquals(3121910778619L, banks.getBestJoltageSum());
    }

    @Test
    void bestDuoOf() throws Exception {
        Banks banks = new Banks(2);
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{9, 8}), banks.bestJoltageOf(Arrays.asList(new Short[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1})));
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{8, 9}), banks.bestJoltageOf(Arrays.asList(new Short[]{8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9})));
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{7, 8}), banks.bestJoltageOf(Arrays.asList(new Short[]{2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8})));
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{9, 2}), banks.bestJoltageOf(Arrays.asList(new Short[]{8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1})));
    }

    @Test
    void bestJoltageOf_01() throws Exception {
        Banks banks = new Banks(12);
        List<Short> result;

        result = banks.bestJoltageOf(Banks.lineToBatteries("987654321111111"));
        Assertions.assertIterableEquals(Banks.lineToBatteries("987654321111"), result);
    }

    @Test
    void bestJoltageOf_02() throws Exception {
        Banks banks = new Banks(12);
        List<Short> result;

        result = banks.bestJoltageOf(Banks.lineToBatteries("811111111111119"));
        Assertions.assertIterableEquals(Banks.lineToBatteries("811111111119"), result);

    }

    @Test
    void bestJoltageOf_03() throws Exception {
        Banks banks = new Banks(12);
        List<Short> result;

        result = banks.bestJoltageOf(Banks.lineToBatteries("234234234234278"));
        Assertions.assertIterableEquals(Banks.lineToBatteries("434234234278"), result);

    }

    @Test
    void bestJoltageOf_04() throws Exception {
        Banks banks = new Banks(12);
        List<Short> result;

        result = banks.bestJoltageOf(Banks.lineToBatteries("818181911112111"));
        Assertions.assertIterableEquals(Banks.lineToBatteries("888911112111"), result);
    }

}