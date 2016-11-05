package me.rogalsp1.virtualcamera.view;

import me.rogalsp1.virtualcamera.model.VirtualCamera;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Controller {
    private DrawingPanel drawingPanel;
    private VirtualCamera virtualCamera;

    public Controller(DrawingPanel drawingPanel, VirtualCamera virtualCamera) {
        this.drawingPanel = drawingPanel;
        this.virtualCamera = virtualCamera;
    }

    public void zoomIn() {
        virtualCamera.zoomIn();
        repaintPanel();
    }

    public void zoomOut() {
        virtualCamera.zoomOut();
        repaintPanel();
    }

    public void translationPlusOX() {
        virtualCamera.translationPlusOX();
        repaintPanel();
    }

    public void translationMinusOX() {
        virtualCamera.translationMinusOX();
        repaintPanel();
    }

    public void translationPlusOY() {
        virtualCamera.translationPlusOY();
        repaintPanel();
    }

    public void translationMinusOY() {
        virtualCamera.translationMinusOY();
        repaintPanel();
    }

    public void translationPlusOZ() {
        virtualCamera.translationPlusOZ();
        repaintPanel();
    }

    public void translationMinusOZ() {
        virtualCamera.translationMinusOZ();
        repaintPanel();
    }

    public void rotationPlusOX() {
        virtualCamera.rotationPlusOX();
        repaintPanel();
    }

    public void rotationMinusOX() {
        virtualCamera.rotationMinusOX();
        repaintPanel();
    }

    public void rotationPlusOY() {
        virtualCamera.rotationPlusOY();
        repaintPanel();
    }

    public void rotationMinusOY() {
        virtualCamera.rotationMinusOY();
        repaintPanel();
    }

    public void rotationPlusOZ() {
        virtualCamera.rotationPlusOZ();
        repaintPanel();
    }

    public void rotationMinusOZ() {
        virtualCamera.rotationMinusOZ();
        repaintPanel();
    }

    public void resetTransformation() {
        virtualCamera.resetTransformation();
        repaintPanel();
    }

    private void repaintPanel(boolean z) {
        this.drawingPanel.repaint(virtualCamera.getEdgesToDraw());
    }

    private void repaintPanel() {
        this.drawingPanel.repaint(virtualCamera.getEdgesToDraw());
    }
}
