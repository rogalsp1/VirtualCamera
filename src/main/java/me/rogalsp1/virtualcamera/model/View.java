package me.rogalsp1.virtualcamera.model;

import me.rogalsp1.virtualcamera.Properties;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class View {
    private List<Edge2D> edgesToView;
    private Camera camera;

    public View(Camera camera) {
        this.camera = camera;
        this.edgesToView = convertTo2D(camera.getEdgesInCamera());
    }

    private List<Edge2D> convertTo2D(List<Edge3D> edgeList) {
        return edgeList.stream().map(x -> convertTo2D(x)).collect(Collectors.toList());
    }

    private Edge2D convertTo2D(Edge3D edge3D) {
        return new Edge2D(convertTo2D(edge3D.getPoint1()), convertTo2D(edge3D.getPoint2()));
    }

    private Point2D convertTo2D(Point3D point3D) {
        double x = ((point3D.getX() - camera.getX_min()) * Properties.DRAWING_WINDOW_WIDTH / (camera.getX_max() - camera.getX_min()));
        double y = Properties.DRAWING_WINDOW_HEIGHT - ((int) ((point3D.getY()
                - camera.getY_min()) * Properties.DRAWING_WINDOW_HEIGHT / (camera.getY_max() - camera.getY_min())));
        return new Point2D(x,y, point3D.getZ());
    }

    public List<Edge2D> getEdgesToView() {
        return edgesToView;
    }

    public void setEdgesToView(List<Edge2D> edgesToView) {
        this.edgesToView = edgesToView;
    }
}
