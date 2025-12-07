package net.laedanrex.adventcode.of2025.day06;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class CephalopodCalculator {

    StringGrid<String> grid = new StringGrid<>();

    public void addLine(String lineString) {
        grid.addLine(lineString.split(""));
        System.out.println(grid.getLastRow());
    }

    public Long calculateGrandTotal() {
        Long result = 0L;
        for (int i = 0; i < grid.sizeX; i++) {
            result += calculateColumn(i);
        }
        return result;
    }

    public Long calculateColumn(int x) {
        List<String> col = grid.getColumn(x);
        BiFunction<Long, Long, Long> operation = getOperation(col.getLast());
        Long result = Long.parseLong(col.get(0));
        for (int i = 1; i < col.size() - 1; i++) {
            result = operation.apply(result, Long.parseLong(col.get(i)));
        }
        return result;
    }

    private BiFunction<Long, Long, Long> getOperation(String operator) {
        switch (operator) {
            case "+":
                return Long::sum;
            case "*":
                return (x, y) -> x * y;
            case "-":
                return (x, y) -> x - y;
            case "/":
                return (x, y) -> x / y;
        }
        throw new IllegalArgumentException("Unknown operator: " + operator);
    }

    public Long calculateGrandTotalRightToLeft() {
        String operator;
        List<Long> numbers = new ArrayList<>();
        Long count = 0L;
        for (int x = grid.sizeX - 1; x > -1; x--) {
            List<String> col = grid.getColumn(x);
            Long number = colToNumber(col);
            if (Objects.nonNull(number))
                numbers.add(colToNumber(col));
            operator = col.getLast();
            if (StringUtils.isNotBlank(operator)) {
                Long result = calcNumbersCol(operator, numbers);
                count += result;
                System.out.println("--- > "+count);
                numbers.clear();
            }
        }
        return count;
    }

    Long calcNumbersCol(String operator, List<Long> numbers) {
        BiFunction<Long, Long, Long> operation = getOperation(operator);
        Long result = numbers.getFirst();
        System.out.printf("%d", result);
        for (int i = 1; i < numbers.size(); i++) {
            System.out.printf(" %s %d", operator, numbers.get(i));
            result = operation.apply(result, numbers.get(i));
        }
        System.out.printf(" = %d\n", result);
        return result;
    }

    public Long colToNumber(List<String> col) {
        StringBuilder numberB = new StringBuilder();
        for (int i = 0; i < col.size() - 1; i++) {
            String more = col.get(i);
            if (StringUtils.isNotBlank(more))
                numberB.append(more);
        }
        String number = numberB.toString();
        if (StringUtils.isEmpty(number)) {
            return null;
        }
        return Long.parseLong(number);
    }
}
