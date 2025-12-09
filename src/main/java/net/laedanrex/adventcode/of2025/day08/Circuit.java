package net.laedanrex.adventcode.of2025.day08;

import org.apache.commons.geometry.euclidean.threed.Vector3D;

import java.util.HashSet;
import java.util.Set;

public class Circuit {
    static int idCount = 0;
    String ID;
    Set<Vector3D> points;

    public Circuit(Vector3D point1, Vector3D point2) {
        HashSet<Vector3D> points = new HashSet<Vector3D>();
        points.add(point1);
        points.add(point2);
        this(points);
    }

    public Circuit(Set<Vector3D> points) {
        this.points = points;
        this.ID = "circuit_%02d".formatted(++idCount);
    }

    public static Circuit newCircuitWith(Vector3D point1, Vector3D point2) {
        return new Circuit(point1, point2);
    }

    public Circuit add(Vector3D point) {
        points.add(point);
        return this;
    }

    public boolean contains(Vector3D point) {
        return points.contains(point);
    }

    public int size() {
        return points.size();
    }

    @Override
    public String toString() {
        return "{" + ID + " " + points + "}";
    }
}
