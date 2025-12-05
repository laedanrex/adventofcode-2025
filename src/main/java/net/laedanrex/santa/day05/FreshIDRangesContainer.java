package net.laedanrex.santa.day05;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class FreshIDRangesContainer {

    List<Long> ids = new ArrayList<>();
    List<SimpleRange> freshRanges = new ArrayList<>();
    List<SimpleRange> freshRangesMerged = new ArrayList<>();
    // @Getter
    // Set<Long> possibleFreshIDs = new HashSet<>();

    public void addFreshRangeOrID(String line) {
        if (isBlank(line)) return;
        if (line.contains("-")) addFreshRange(line);
        else addID(line);
    }

    public void addFreshRange(String line) {
        SimpleRange freshRange = new SimpleRange(line);
        freshRanges.add(freshRange);
        // possibleFreshIDs.addAll(freshRange.possibleIdsInclusive());
    }

    public void addID(String line) {
        ids.add(Long.valueOf(line));
    }

    private boolean isInAnyFreshRanges(Long id) {
        return freshRanges.stream().anyMatch(range -> range.containsInclusive(id));
    }

    private boolean isNotInASingleFreshRanges(Long id) {
        return freshRanges.stream().noneMatch(range -> range.containsInclusive(id));
    }

    public List<Long> getFreshIDs() {
        return ids.stream().filter(this::isInAnyFreshRanges).toList();
    }

    public List<Long> getSpoilIDs() {
        return ids.stream().filter(this::isNotInASingleFreshRanges).toList();
    }

    public void mergeFreshRanges() {
        freshRanges.sort(Comparator.comparing(range -> range.min));
        freshRanges.forEach(this::mergeIfPossibleInList);
    }

    public void mergeIfPossibleInList(SimpleRange range) {
        if (freshRangesMerged.isEmpty()) {
            freshRangesMerged.add(range);
            return;
        }
        if (freshRangesMerged.stream().noneMatch((mergedRange) -> mergedRange.mergeIfPossible(range))) {
            freshRangesMerged.add(range);
        }
    }

    public Long getNumberOfPossibleFreshIDs() {
        return freshRangesMerged.stream().mapToLong(range -> range.max - range.min + 1).sum();
    }
}
