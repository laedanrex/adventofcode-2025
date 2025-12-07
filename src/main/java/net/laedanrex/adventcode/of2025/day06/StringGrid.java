package net.laedanrex.adventcode.of2025.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringGrid<T> {
    List<List<T>> grid = new ArrayList<>();
    public int sizeX = 0;
    public int sizeY = 0;

    void addLine(List<T> line) {
        grid.add(line);
        sizeY += 1;
        sizeX = line.size();
    }

    public void addLine(T[] line) {
        addLine(Arrays.asList(line));
    }

    public T get(int x, int y) {
        return grid.get(y).get(x);
    }

    public T set(int x, int y, T value) {
        return grid.get(y).set(x, value);
    }

    public List<T> getRow(int y) {
        return grid.get(y);
    }

    public List<T> getLastRow() {
        return getRow(sizeY - 1);
    }

    public List<T> getColumn(int x) {
        return grid.stream().map(l -> l.get(x)).toList();
    }

    public List<T> getLastColumn() {
        return getColumn(sizeX - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        grid.forEach(l -> builder.append(l.toString()).append("\n"));
        return builder.toString();
    }
}
