package net.laedanrex.santa.day02;

import lombok.Getter;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

@Log
public class Range {

    Long min;
    Long max;
    String minStr;
    String maxStr;
    @Getter
    List<String> invalidIDSTwoPart = new ArrayList<>();
    @Getter
    List<String> invalidIDS = new ArrayList<>();

    public Range(String value) {
        String[] both = value.split("-");
        minStr = both[0];
        maxStr = both[1];
        min = Long.parseLong(minStr);
        max = Long.parseLong(maxStr);
        browseCutAndCheck();
    }

    private void setInvalids() {
        for (long offset = min; offset <= max; offset++) {
            String offsetStr = String.valueOf(offset);
            int mid = offsetStr.length() / 2;
            String[] parts = {offsetStr.substring(0, mid), offsetStr.substring(mid)};
            if (parts[0].equals(parts[1])) {
                invalidIDSTwoPart.add(offsetStr);
            }
        }
    }

    private void browseCutAndCheck() {
        for (long offset = min; offset <= max; offset++) {
            // pour chaque ID
            String offsetStr = String.valueOf(offset);
            log.log(Level.FINE, "offset " + offset);
            if (cutAndCheckAnySimilarity(offsetStr)) {
                invalidIDS.add(offsetStr);
            }
        }
    }

    private boolean cutAndCheckAnySimilarity(String offsetStr) {
        for (int pieces = 2; pieces <= offsetStr.length(); pieces++) {
            // pour chaque découpage
            log.log(Level.FINE, "  pieces " + pieces);
            if (anySimilarity(pieces, offsetStr)) {
                return true;
            }
        }
        return false;
    }

    private boolean anySimilarity(int pieces, String offsetStr) {
        int len = offsetStr.length() / pieces;
        String[] parts = new String[pieces];
        for (int piece = 0; piece < pieces; piece++) {
            int start = piece * len;
            int end = start + len;
            if (piece == pieces - 1) {
                end = offsetStr.length();
            }
            if (end > offsetStr.length()) {
                end = offsetStr.length();
            }
            log.log(Level.FINEST, "     start " + start + " end " + end);
            log.log(Level.FINEST, "     substring " + offsetStr.substring(start, end));
            parts[piece] = offsetStr.substring(start, end);
            log.log(Level.FINE, "   part " + piece + " = " + parts[piece]);
        }
        return allSimiliar(parts);
    }

    private boolean allSimiliar(String[] parts) {
        return Arrays.stream(parts)
                .distinct()
                .count() == 1;
    }

    public Long sumOfAllInvalid() {
        return invalidIDS.stream().mapToLong(Long::parseLong).sum();
    }

    @Override
    public String toString() {
        return "%15s - %s".formatted(minStr, maxStr);
    }
}
