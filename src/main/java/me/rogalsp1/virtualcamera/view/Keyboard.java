package me.rogalsp1.virtualcamera.view;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class Keyboard implements KeyEventDispatcher{

    private Controller controller;

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyChar() == '=') {
            controller.zoomIn();
        }
        if (e.getKeyChar() == '-') {
            controller.zoomOut();
        }
        if (e.getKeyChar() == 'd') {
            controller.translationMinusOX();
        }
        if (e.getKeyChar() == 'a') {
            controller.translationPlusOX();
        }
        if (e.getKeyChar() == 'w') {
            controller.translationMinusOY();
        }
        if (e.getKeyChar() == 's') {
            controller.translationPlusOY();
        }
        if (e.getKeyChar() == 'q') {
            controller.translationMinusOZ();
        }
        if (e.getKeyChar() == 'e') {
            controller.translationPlusOZ();
        }
        if (e.getKeyChar() == 'l') {
            controller.rotationPlusOX();
        }
        if (e.getKeyChar() == 'j') {
            controller.rotationMinusOX();
        }
        if (e.getKeyChar() == 'i') {
            controller.rotationPlusOY();
        }
        if (e.getKeyChar() == 'k') {
            controller.rotationMinusOY();
        }
        if (e.getKeyChar() == 'o') {
            controller.rotationPlusOZ();
        }
        if (e.getKeyChar() == 'u') {
            controller.rotationMinusOZ();
        }
        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
            controller.resetTransformation();
        }
        return false;
    }
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


}
