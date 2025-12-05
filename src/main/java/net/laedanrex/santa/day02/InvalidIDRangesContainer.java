package net.laedanrex.santa.day02;

import java.util.ArrayList;
import java.util.List;

public class InvalidIDRangesContainer {

    List<InvalidIDRange> invalidIDRanges = new ArrayList<InvalidIDRange>();


    public void addRanges(String line) {
        String[] rangesStr = line.split(",");
        for (String rangeStr : rangesStr) {
            invalidIDRanges.add(new InvalidIDRange(rangeStr));
        }
    }

    public Long sumOfAllInvalid() {
        return invalidIDRanges.stream().mapToLong(InvalidIDRange::sumOfAllInvalid).sum();
    }

    public void printSumOfAllInvalid() {
        System.out.println(sumOfAllInvalid());
    }

    public List<String> getAllInvalidIDS() {
        return invalidIDRanges.stream()
                .flatMap(invalidIDRange -> invalidIDRange.getInvalidIDS().stream())
                .toList();
    }

    public void printAllInvalidIDS() {
        invalidIDRanges.forEach(invalidIDRange -> System.out.println(invalidIDRange.getInvalidIDS()));
    }


    // -----------------------------------------------------------------
    void printRanges() {
        //System.out.printf("         |    N°   |  0 HIT  | 0 LAND  \n");
        //System.out.printf("---------|---------|---------|---------\n");
        invalidIDRanges.forEach(System.out::println);
    }
}
