package net.laedanrex.adventcode.of2025.day03;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banks {

    Integer joltageSize;


    public Banks() {
        this(2);
    }

    public Banks(Integer joltageSize) {
        this.joltageSize = joltageSize;
    }

    List<List<Short>> batteriesList = new ArrayList<>();
    @Getter
    List<List<Short>> bestJoltage = new ArrayList<>();

    public void addBatteries(String line) {
        //System.out.printf(" \n");
        List<Short> newBatteries = lineToBatteries(line);
        batteriesList.add(newBatteries);
        bestJoltage.add(bestJoltageOf(newBatteries));
    }

    public static List<Short> lineToBatteries(String line) {
        List<Short> newBatteries = new ArrayList<>();
        for (char ch : line.toCharArray()) {
            Short s = Short.parseShort(String.valueOf(ch));
            //System.out.printf(" " + s);
            newBatteries.add(s);
        }
        return newBatteries;
    }

    public static Long batteriesToJoltage(List<Short> batteries) {
        String s = batteries.stream().map(e -> Short.toString(e)).collect(Collectors.joining());
        return Long.parseLong(s);
    }

    List<Short> bestJoltageOf(List<Short> batteries) {
        return recBestJoltageOf(batteries, joltageSize, new ArrayList<>(joltageSize));
    }

    List<Short> recBestJoltageOf(List<Short> batteries, int joltageSize, List<Short> actualJoltage) {
        if (joltageSize == 0) {
            return actualJoltage;
        }
        Short best = 0;
        int bestOffset = 0;
        for (int i = batteries.size() - joltageSize; i >= 0; i--) {
            if (batteries.get(i) >= best) {
                best = batteries.get(i);
                bestOffset = i;
            }
        }
        actualJoltage.add(best);
        return recBestJoltageOf(batteries.subList(bestOffset + 1, batteries.size()), joltageSize - 1, actualJoltage);
    }


    public long getBestJoltageSum() {
        return bestJoltage.stream().mapToLong(Banks::batteriesToJoltage)
                .sum();
    }

}
