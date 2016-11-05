package me.rogalsp1.virtualcamera.view;

import me.rogalsp1.virtualcamera.Properties;
import me.rogalsp1.virtualcamera.model.Scene;
import me.rogalsp1.virtualcamera.model.VirtualCamera;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class VirtualCameraMain {
    
    public static void main( String[] args ) {
        MainWindow mainWindow = new MainWindow();
        Keyboard keyboard = new Keyboard();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyboard);
        Scene scene = new Scene();
        VirtualCamera virtualCamera = new VirtualCamera(scene,Properties.INITIAL_PROJECTION_DISTANCE);
        virtualCamera.processScene();
        DrawingPanel drawingPanel = new DrawingPanel(virtualCamera.getEdgesToDraw());
        Controller controller = new Controller(drawingPanel,virtualCamera);
        keyboard.setController(controller);
        mainWindow.getContentPane().add(drawingPanel, BorderLayout.CENTER);
        drawingPanel.init();
        String manual = "Translacje: oś OX - a d , oś OY - w s , oś OZ - q e ; Obroty: oś OX - l j , oś OY - i k, oś OZ - o u ; Przyblizanie: = -";
        JTextArea text= new JTextArea(manual);
        text.setBackground(Color.LIGHT_GRAY);
        text.setEditable(false);
        mainWindow.getContentPane().add(text,BorderLayout.NORTH);
        mainWindow.setFocusable(true);
        mainWindow.pack();
        mainWindow.setSize(Properties.MAIN_WINDOW_WIDTH, Properties.MAIN_WINDOW_HEIGHT);
        mainWindow.setVisible(true);
    }
}
