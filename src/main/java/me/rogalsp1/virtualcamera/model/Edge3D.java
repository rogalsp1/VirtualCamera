package me.rogalsp1.virtualcamera.model;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Edge3D {

    private Point3D point1;
    private Point3D point2;


    public Edge3D(Point3D point1, Point3D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point3D getPoint1() {
        return point1;
    }

    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public void setPoint2(Point3D point2) {
        this.point2 = point2;
    }
}
