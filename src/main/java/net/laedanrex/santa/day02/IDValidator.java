package net.laedanrex.santa.day02;

import java.util.ArrayList;
import java.util.List;

public class IDValidator {

    List<Range> ranges = new ArrayList<Range>();


    public void addRanges(String line) {
        String[] rangesStr = line.split(",");
        for (String rangeStr : rangesStr) {
            ranges.add(new Range(rangeStr));
        }
    }

    public Long sumOfAllInvalid() {
        return ranges.stream().mapToLong(Range::sumOfAllInvalid).sum();
    }

    public void printSumOfAllInvalid() {
        System.out.println(sumOfAllInvalid());
    }

    public List<String> getAllInvalidIDS() {
        return ranges.stream()
                .flatMap(range -> range.getInvalidIDS().stream())
                .toList();
    }

    public void printAllInvalidIDS() {
        ranges.forEach(range -> System.out.println(range.getInvalidIDS()));
    }


    // -----------------------------------------------------------------
    void printRanges() {
        //System.out.printf("         |    N°   |  0 HIT  | 0 LAND  \n");
        //System.out.printf("---------|---------|---------|---------\n");
        ranges.forEach(System.out::println);
    }
}
