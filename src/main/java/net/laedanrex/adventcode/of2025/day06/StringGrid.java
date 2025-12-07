package net.laedanrex.adventcode.of2025.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringGrid<T> {
    List<List<T>> grid = new ArrayList<>();
    int sizeX = 0;
    int sizeY = 0;

    void addLine(List<T> line) {
        grid.add(line);
        sizeY += 1;
        sizeX = line.size();
    }

    void addLine(T[] line) {
        addLine(Arrays.asList(line));
    }

    T get(int x, int y) {
        return grid.get(y).get(x);
    }

    List<T> getRow(int y) {
        return grid.get(y);
    }

    List<T> getLastRow() {
        return getRow(sizeY - 1);
    }

    List<T> getColumn(int x) {
        return grid.stream().map(l -> l.get(x)).toList();
    }

    List<T> getLastColumn() {
        return getColumn(sizeX - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        grid.forEach(l -> builder.append(l.toString()).append("\n"));
        return builder.toString();
    }
}
