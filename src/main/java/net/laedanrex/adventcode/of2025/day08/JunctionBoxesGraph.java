package net.laedanrex.adventcode.of2025.day08;

import org.apache.commons.geometry.euclidean.threed.Vector3D;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class JunctionBoxesGraph {

    List<Vector3D> junctionBoxes = new ArrayList<>();
    List<Circuit> circuitsGroups;
    List<Distance3D> distances;

    public void addVector(String lineString) {
        String[] elements = lineString.split(",");
        Vector3D vector3D = Vector3D.of(
                Integer.parseInt(elements[0]),
                Integer.parseInt(elements[1]),
                Integer.parseInt(elements[2])
        );
        // System.out.println("Adding vector: " + vector3D);
        junctionBoxes.add(vector3D);
    }

    // Multiplying together the sizes of the three largest circuits (5, 4, and one of the circuits of size 2) produces 40.
    public int get3LargestsCircuitsMultiplication(Integer limit) {
        groupCircuit(limit);
        System.out.println("circuitsGroups.size() " + circuitsGroups.size());
        for (int i = 0; i < circuitsGroups.size(); i++) {
            System.out.println("circuitsGroups.get(" + i + ").size() " + circuitsGroups.get(i).size());
        }
        return circuitsGroups.get(0).size() *
                circuitsGroups.get(1).size() *
                circuitsGroups.get(2).size();
    }

    private void groupCircuit(Integer limit) {
        circuitsGroups = new ArrayList<>();
        processDistances();
        if (Objects.isNull(limit)) limit = distances.size();
        else limit = limit + 1;
        System.out.println("limit " + limit);
        for (int distanceOffset = 0; distanceOffset < limit; distanceOffset++) {
            Distance3D distance = distances.get(distanceOffset);
            System.out.println(distance);
            if (!checkIfPresentAndAdd(distance)) {
                Circuit newCircuit = Circuit.newCircuitWith(distance.point1, distance.point2);
                System.out.println("  NEW");
                System.out.println("  " + newCircuit);
                circuitsGroups.add(newCircuit);
            }
        }
        circuitsGroups.sort(Comparator.comparing(Circuit::size).reversed());
    }

    boolean checkIfPresentAndAdd(Distance3D distance) {
        for (Circuit existingCircuit : circuitsGroups) {
            boolean containsP1 = existingCircuit.contains(distance.point1);
            boolean containsP2 = existingCircuit.contains(distance.point2);
            if (containsP1 && containsP2) {
                System.out.println("  ALREADY PRESENTS");
                System.out.println(existingCircuit);
                return true;
            } else if (containsP1) {
                System.out.println("  ADD");
                System.out.println(existingCircuit + "  " + distance.point2);
                existingCircuit.add(distance.point2);
                return true;
            } else if (containsP2) {
                System.out.println("  ADD");
                System.out.println(existingCircuit + "  " + distance.point1);
                existingCircuit.add(distance.point1);
                return true;
            }
        }
        return false;
    }

    List<Distance3D> processDistances() {
        distances = new ArrayList<>();
        System.out.println("processDistances()");
        for (int i = 0; i < junctionBoxes.size() - 1; i++) {
            Vector3D point1 = junctionBoxes.get(i);
            for (int j = i + 1; j < junctionBoxes.size(); j++) {
                Vector3D point2 = junctionBoxes.get(j);
                distances.add(Distance3D.of(point1, point2));
            }
        }
        System.out.println("distances.sort() + " + distances.size());
        distances.sort(Comparator.comparing(Distance3D::getDistance));
        return distances;
    }
}
