package net.laedanrex.adventcode.of2025.day07;

import net.laedanrex.adventcode.of2025.day06.StringGrid;

public class TachyonBeamSplitting {

    public StringGrid<String> grid = new StringGrid<>();
    int startOffset;

    public void addLine(String lineString) {
        if (lineString.contains("S")) {
            startOffset = lineString.lastIndexOf("S");
        }
        grid.addLine(lineString.split(""));
        //System.out.println(grid.getLastRow());
    }

    public int splits() {
        return splitsRecurciv(startOffset, 1);
    }

    public long paths() {
        return pathsRecurciv(startOffset, 1);
    }

    public int splitsRecurciv(int x, int y) {
        if (y >= grid.sizeY || grid.get(x, y).equals("|")) return 0;
        if (grid.get(x, y).equals(".")) {
            grid.set(x, y, "|");
            return splitsRecurciv(x, y + 1);
        } else if (grid.get(x, y).equals("^")) {
            return 1 + splitsRecurciv(x - 1, y + 1) + splitsRecurciv(x + 1, y + 1);
        }
        throw new IllegalStateException("wrong place :(" + x + "," + y + ") = " + grid.get(x, y));
    }

    public long pathsRecurciv(int x, int y) {
        if (y >= grid.sizeY) return 1L;
        String position = grid.get(x, y);
        if (position.equals(".")) {
            long paths = pathsRecurciv(x, y + 1);
            grid.set(x, y, String.valueOf(paths));
            return paths;
        } else if (position.equals("^")) {
            return pathsRecurciv(x - 1, y + 1) + pathsRecurciv(x + 1, y + 1);
        } else {
            return Long.parseLong(position);
        }
    }

}
