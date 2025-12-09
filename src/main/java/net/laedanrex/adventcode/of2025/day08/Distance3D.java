package net.laedanrex.adventcode.of2025.day08;

import lombok.Getter;
import org.apache.commons.geometry.euclidean.threed.Vector3D;

import java.util.Objects;

public class Distance3D {
    static int idCount = 0;
    String ID;
    Vector3D point1;
    Vector3D point2;
    @Getter
    double distance;

    public static Distance3D of(Vector3D point1, Vector3D point2) {
        return new Distance3D(point1, point2);
    }

    public Distance3D(Vector3D point1, Vector3D point2) {
        this.point1 = point1;
        this.point2 = point2;
        distance = point1.distance(point2);
        if (distance < 0) System.out.println("Error: distance is negative");
        this.ID = "distance_%02d".formatted(++idCount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Distance3D that = (Distance3D) o;
        return Double.compare(distance, that.distance) == 0
                && (Objects.equals(point1, that.point1) && Objects.equals(point2, that.point2)
                ||
                Objects.equals(point1, that.point2) && Objects.equals(point2, that.point1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public String toString() {
        return "{" + ID + " : " + point1 + point2 + "}";
    }
}
