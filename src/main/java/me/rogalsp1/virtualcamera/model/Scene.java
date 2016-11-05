package me.rogalsp1.virtualcamera.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Scene {
    private List<Edge3D> edgeList;
    private Matrix matrix;

    public Scene () {
        edgeList = new ArrayList<>();
        matrix = new Matrix(Matrix.identityMatrix());
        addCuboid(-50, -20, 145, -30, 50, 200);
        addCuboid(50, -20, 145, 30, 50, 200);
    }

    private void addCuboid(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        Point3D point1 = new Point3D(minX, minY, minZ);
        Point3D point2 = new Point3D(maxX, minY, minZ);
        Point3D point3 = new Point3D(maxX, minY, maxZ);
        Point3D point4 = new Point3D(minX, minY, maxZ);
        Point3D point5 = new Point3D(minX, maxY, minZ);
        Point3D point6 = new Point3D(maxX, maxY, minZ);
        Point3D point7 = new Point3D(maxX, maxY, maxZ);
        Point3D point8 = new Point3D(minX, maxY, maxZ);

        Edge3D edge1 = new Edge3D(point1, point2);
        Edge3D edge2 = new Edge3D(point2, point3);
        Edge3D edge3 = new Edge3D(point3, point4);
        Edge3D edge4 = new Edge3D(point4, point1);

        Edge3D edge5 = new Edge3D(point5, point6);
        Edge3D edge6 = new Edge3D(point6, point7);
        Edge3D edge7 = new Edge3D(point7, point8);
        Edge3D edge8 = new Edge3D(point8, point5);

        Edge3D edge9 = new Edge3D(point1, point5);
        Edge3D edge10 = new Edge3D(point2, point6);
        Edge3D edge11 = new Edge3D(point3, point7);
        Edge3D edge12 = new Edge3D(point4, point8);

        edgeList.add(edge1);
        edgeList.add(edge2);
        edgeList.add(edge3);
        edgeList.add(edge4);
        edgeList.add(edge5);
        edgeList.add(edge6);
        edgeList.add(edge7);
        edgeList.add(edge8);
        edgeList.add(edge9);
        edgeList.add(edge10);
        edgeList.add(edge11);
        edgeList.add(edge12);
    }

    private void addEdge(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        Point3D point1 = new Point3D(minX, minY, minZ);
        Point3D point2 = new Point3D(maxX, maxY, maxZ);
        edgeList.add(new Edge3D(point1,point2));
    }

    public List<Edge3D> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge3D> edgeList) {
        this.edgeList = edgeList;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
