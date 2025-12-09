package net.laedanrex.adventcode.of2025.day08;

import net.laedanrex.adventcode.of2025.ResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

class JunctionBoxesGraphTest {

    @Test
    void addVector() throws Exception {
        JunctionBoxesGraph junctionBoxesGraph = new JunctionBoxesGraph();
        Files.lines(ResourcesUtils.getResourcePath("day08/input_01_test"))
                .forEach(junctionBoxesGraph::addVector);
        System.out.println(junctionBoxesGraph.junctionBoxes);
    }

    @Test
    void testAddVector() throws Exception {
    }

    @Test
    void processDistances() throws Exception {
        JunctionBoxesGraph junctionBoxesGraph = new JunctionBoxesGraph();
        Files.lines(ResourcesUtils.getResourcePath("day08/input_01_test"))
                .forEach(junctionBoxesGraph::addVector);
        System.out.println(junctionBoxesGraph.processDistances());
    }

    @Test
    void get3LargestsCircuitsMultiplication() throws Exception {
        JunctionBoxesGraph junctionBoxesGraph = new JunctionBoxesGraph();
        Files.lines(ResourcesUtils.getResourcePath("day08/input_01_test"))
                .forEach(junctionBoxesGraph::addVector);
       int result = junctionBoxesGraph.get3LargestsCircuitsMultiplication(10);
        //Assertions.assertEquals(11,junctionBoxesGraph.circuitsGroups.size());
        System.out.println(result);
        Assertions.assertEquals(40,result);

    }
}