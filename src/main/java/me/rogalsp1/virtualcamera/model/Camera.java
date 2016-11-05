package me.rogalsp1.virtualcamera.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Camera {
    private double x_min = -1;
    private double x_max = 1;
    private double y_min = -1;
    private double y_max = 1;

    private List<Edge3D> edgesInCamera;

    public Camera(List<Edge3D> edges) {
        this.edgesInCamera = edges.stream().filter(x-> isEdgeInCamera(x)).collect(Collectors.toList());
    }

    private boolean isEdgeInCamera(Edge3D edge3D) {
        return isPointInCamera(edge3D.getPoint1()) && isPointInCamera(edge3D.getPoint2());
    }

    private boolean isPointInCamera(Point3D point3D) {
        return ((point3D.getX() >= x_min && point3D.getX() <= x_max) || (point3D.getY() >= y_min && point3D.getY() <= y_max));
    }

    public double getX_min() {
        return x_min;
    }

    public void setX_min(double x_min) {
        this.x_min = x_min;
    }

    public double getX_max() {
        return x_max;
    }

    public void setX_max(double x_max) {
        this.x_max = x_max;
    }

    public double getY_min() {
        return y_min;
    }

    public void setY_min(double y_min) {
        this.y_min = y_min;
    }

    public double getY_max() {
        return y_max;
    }

    public void setY_max(double y_max) {
        this.y_max = y_max;
    }

    public List<Edge3D> getEdgesInCamera() {
        return edgesInCamera;
    }

    public void setEdgesInCamera(List<Edge3D> edgesInCamera) {
        this.edgesInCamera = edgesInCamera;
    }
}
