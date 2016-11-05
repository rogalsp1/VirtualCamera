package me.rogalsp1.virtualcamera.model;

import me.rogalsp1.virtualcamera.Properties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class VirtualCamera {

    private Scene scene;
    private Projection projection;
    private Camera camera;
    private List<Edge3D> edgeList;
    private View view;
    private double projectionDistance;

    public VirtualCamera(Scene scene, double projectionDistance) {
        this.scene = scene;
        this.projectionDistance = projectionDistance;
    }

    public void processScene() {
        edgeList = new ArrayList<>();
        for (Edge3D edge3D : scene.getEdgeList()) {
            Point3D point1 = new Point3D(Matrix.multiply(scene.getMatrix().getMatrix(),edge3D.getPoint1().matrix()));
            Point3D point2 = new Point3D(Matrix.multiply(scene.getMatrix().getMatrix(),edge3D.getPoint2().matrix()));
            edgeList.add(new Edge3D(point1,point2));
        }

        projection = new Projection(projectionDistance);
        camera = new Camera(projection.projectEdges(edgeList));
        view = new View(camera);

    }

    public List<Edge2D> getEdgesToDraw() {
        return this.view.getEdgesToView();
    }

    public void zoomIn() {
        this.projectionDistance += Properties.ZOOM_STEP_VALUE;
        processScene();
    }

    public void zoomOut() {
        if(this.projectionDistance > Properties.ZOOM_STEP_VALUE) {
            this.projectionDistance -= Properties.ZOOM_STEP_VALUE;
            processScene();
        }
    }

    public void translationPlusOX() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.translationMatrix(1 * Properties.TRANSLATION_STEP_VALUE,0,0),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void translationMinusOX() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.translationMatrix(-1 * Properties.TRANSLATION_STEP_VALUE,0,0),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void translationPlusOY() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.translationMatrix(0, 1 * Properties.TRANSLATION_STEP_VALUE,0),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void translationMinusOY() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.translationMatrix(0, -1 * Properties.TRANSLATION_STEP_VALUE,0),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void translationPlusOZ() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.translationMatrix(0, 0, 1 * Properties.TRANSLATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void translationMinusOZ() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.translationMatrix(0, 0, -1 * Properties.TRANSLATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void rotationPlusOX() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.rotationOX(Properties.ROTATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void rotationMinusOX() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.rotationOX(-1*Properties.ROTATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void rotationPlusOY() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.rotationOY(Properties.ROTATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void rotationMinusOY() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.rotationOY(-1*Properties.ROTATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }
    public void rotationPlusOZ() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.rotationOZ(Properties.ROTATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void rotationMinusOZ() {
        this.scene.getMatrix().setMatrix(Matrix.multiply(Matrix.rotationOZ(-1*Properties.ROTATION_STEP_VALUE),
                this.scene.getMatrix().getMatrix()));
        processScene();
    }

    public void resetTransformation() {
        this.scene.getMatrix().setMatrix(Matrix.identityMatrix());
        this.projectionDistance = Properties.INITIAL_PROJECTION_DISTANCE;
        processScene();
    }
}
