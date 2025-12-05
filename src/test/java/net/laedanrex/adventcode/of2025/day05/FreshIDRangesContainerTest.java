package net.laedanrex.adventcode.of2025.day05;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreshIDRangesContainerTest {

    @Test
    void addFreshRangeOrID() {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        container.addFreshRangeOrID("9-24");
        container.addFreshRangeOrID(" ");
        container.addFreshRangeOrID("1");
        assertEquals(1, container.ids.size());
        assertEquals(1, container.freshRanges.size());
    }

    @Test
    void addID() {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        container.addID("2");
        assertEquals(1, container.ids.size());
        assertEquals(2, container.ids.get(0));
    }

    @Test
    void addFreshRange() {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        container.addFreshRange("2-3");
        assertEquals(1, container.freshRanges.size());
        assertEquals(2, container.freshRanges.get(0).min);
        assertEquals(3, container.freshRanges.get(0).max);
    }

    @Test
    void simpleRange() {
        SimpleRange simpleRange = new SimpleRange("9-25");
        assertTrue(simpleRange.containsInclusive(9L));
        assertTrue(simpleRange.containsInclusive(22L));
        assertTrue(simpleRange.containsInclusive(25L));
        assertFalse(simpleRange.containsInclusive(26L));
        assertFalse(simpleRange.containsInclusive(8L));
    }

    @Test
    void getFreshIDs() throws Exception {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day05/input_01_test"))
                .forEach(container::addFreshRangeOrID);
        System.out.println(container.getFreshIDs());
        assertIterableEquals(List.of(5L, 11L, 17L), container.getFreshIDs());
    }

    @Test
    void getSpoilIDs() throws Exception {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day05/input_01_test"))
                .forEach(container::addFreshRangeOrID);
        System.out.println(container.getSpoilIDs());
        assertIterableEquals(List.of(1L, 8L, 32L), container.getSpoilIDs());
    }

    @Test
    void getPossibleIDs() throws Exception {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day05/input_01_test"))
                .forEach(container::addFreshRangeOrID);
        // System.out.println(container.getPossibleFreshIDs());
        // assertIterableEquals(List.of(3L, 4L, 5L, 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L)
        //         , container.getPossibleFreshIDs());
    }

    @Test
    void getNumberOfPossibleFreshIDs() throws Exception {
        FreshIDRangesContainer container = new FreshIDRangesContainer();
        Files.lines(ResourcesUtils.getResourcePath("day05/input_01_test"))
                .forEach(container::addFreshRangeOrID);
        container.mergeFreshRanges();
        System.out.println(container.getNumberOfPossibleFreshIDs());
        assertEquals(14, container.getNumberOfPossibleFreshIDs());
    }
}