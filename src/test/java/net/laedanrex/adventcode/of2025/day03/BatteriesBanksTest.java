package net.laedanrex.adventcode.of2025.day03;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

class BatteriesBanksTest {

    @Test
    void addBatteries() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(12);
        Files.lines(ResourcesUtils.getResourcePath("day03/input_01_test"))
                .forEach(batteriesBanks::addBatteries);

        Assertions.assertEquals(3121910778619L, batteriesBanks.getBestJoltageSum());
    }

    @Test
    void bestDuoOf() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(2);
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{9, 8}), batteriesBanks.bestJoltageOf(Arrays.asList(new Short[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1})));
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{8, 9}), batteriesBanks.bestJoltageOf(Arrays.asList(new Short[]{8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9})));
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{7, 8}), batteriesBanks.bestJoltageOf(Arrays.asList(new Short[]{2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8})));
        Assertions.assertIterableEquals(Arrays.asList(new Short[]{9, 2}), batteriesBanks.bestJoltageOf(Arrays.asList(new Short[]{8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1})));
    }

    @Test
    void bestJoltageOf_01() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(12);
        List<Short> result;

        result = batteriesBanks.bestJoltageOf(BatteriesBanks.lineToBatteries("987654321111111"));
        Assertions.assertIterableEquals(BatteriesBanks.lineToBatteries("987654321111"), result);
    }

    @Test
    void bestJoltageOf_02() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(12);
        List<Short> result;

        result = batteriesBanks.bestJoltageOf(BatteriesBanks.lineToBatteries("811111111111119"));
        Assertions.assertIterableEquals(BatteriesBanks.lineToBatteries("811111111119"), result);

    }

    @Test
    void bestJoltageOf_03() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(12);
        List<Short> result;

        result = batteriesBanks.bestJoltageOf(BatteriesBanks.lineToBatteries("234234234234278"));
        Assertions.assertIterableEquals(BatteriesBanks.lineToBatteries("434234234278"), result);

    }

    @Test
    void bestJoltageOf_04() throws Exception {
        BatteriesBanks batteriesBanks = new BatteriesBanks(12);
        List<Short> result;

        result = batteriesBanks.bestJoltageOf(BatteriesBanks.lineToBatteries("818181911112111"));
        Assertions.assertIterableEquals(BatteriesBanks.lineToBatteries("888911112111"), result);
    }

}