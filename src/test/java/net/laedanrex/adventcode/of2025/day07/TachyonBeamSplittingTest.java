package net.laedanrex.adventcode.of2025.day07;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class TachyonBeamSplittingTest {


    @Test
    void splits() throws Exception {
        TachyonBeamSplitting beamSplitting = new TachyonBeamSplitting();
        Files.lines(ResourcesUtils.getResourcePath("day07/input_01_test"))
                .forEach(beamSplitting::addLine);

        Assertions.assertEquals(21, beamSplitting.splits());
    }

    @Test
    void paths() throws Exception {
        TachyonBeamSplitting beamSplitting = new TachyonBeamSplitting();
        Files.lines(ResourcesUtils.getResourcePath("day07/input_01_test"))
                .forEach(beamSplitting::addLine);

        Assertions.assertEquals(40, beamSplitting.paths());
    }

}