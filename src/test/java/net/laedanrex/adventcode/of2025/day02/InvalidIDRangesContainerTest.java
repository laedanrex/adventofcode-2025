package net.laedanrex.adventcode.of2025.day02;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class InvalidIDRangesContainerTest {

    @Test
    void addRanges() throws Exception {
        InvalidIDRangesContainer invalidIDRangesContainer = new InvalidIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day02/input_01_test"))
                .forEach(invalidIDRangesContainer::addRanges);
        System.out.println(invalidIDRangesContainer.getAllInvalidIDS());
        System.out.println("SUM=" + invalidIDRangesContainer.sumOfAllInvalid());
    }

}