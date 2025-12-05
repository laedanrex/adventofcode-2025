package net.laedanrex.adventcode.of2025.day05;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class SimpleRange {

    Long min;
    Long max;
    String minStr;
    String maxStr;

    public SimpleRange(String value) {
        String[] both = value.split("-");
        minStr = both[0];
        maxStr = both[1];
        min = Long.parseLong(minStr);
        max = Long.parseLong(maxStr);
        if (min >= max) {
            System.out.println(minStr + " is greater than " + maxStr);
        }
    }

    public boolean containsInclusive(Long id) {
        return min <= id && id <= max;
    }

    public List<Long> possibleIdsInclusive() {
        List<Long> possibilities = new ArrayList<>();
        for (Long i = min; i <= max; i++) {
            possibilities.add(i);
        }
        return possibilities;
    }

    @Override
    public String toString() {
        return "[ %s - %s ]".formatted(minStr, maxStr);
    }

    public boolean mergeIfPossible(SimpleRange rangeToMerge) {
        if (rangeToMerge.min < min) {
            throw new IllegalArgumentException("sort before use");
        }
        if (max < rangeToMerge.min) {
            // [===]...[[---]]
            return false;
        }
        if (min <= rangeToMerge.min && rangeToMerge.max <= max) {
            // [===[[-=-=-]]====]   nothing to do
            return true;
        }
        if (min <= rangeToMerge.min && rangeToMerge.min <= max && max <= rangeToMerge.max) {
            // [===[[-=-=-]----]]
            this.max = rangeToMerge.max;
            return true;
        }
        throw new IllegalArgumentException("Strange to be here");
    }
}
