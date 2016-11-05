package me.rogalsp1.virtualcamera.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Projection {
    private double d;
    private Matrix matrix;
    private double z_min = 0.1;

    public Projection(double d) {
        this.d = d;
        this.matrix = new Matrix(Matrix.projectionMatrix(d));
    }

    public List<Edge3D> projectEdges(List<Edge3D> edgeList) {
        return edgeList.stream().map(x -> projectEdge(x)).collect(Collectors.toList());
    }

    public Edge3D projectEdge(Edge3D edge3D) {
        return new Edge3D(projectPoint(edge3D.getPoint1()), projectPoint(edge3D.getPoint2()));
    }

    /*private Point3D projectPoint(Point3D point3D) {
        return new Point3D(point3D.getX() * this.d/ point3D.getZ(), point3D.getY() * this.d/ point3D.getZ(), this.d);
    }*/

    private Point3D projectPoint(Point3D point3D) {
        double[][] wsp = Matrix.multiply(this.matrix.getMatrix(), point3D.matrix());
        Point3D pkt = new Point3D(wsp[0][0], wsp[1][0], wsp[2][0], wsp[3][0]);
        pkt.normalize();
        return pkt;
    }

}
