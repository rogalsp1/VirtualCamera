package me.rogalsp1.virtualcamera.view;

import me.rogalsp1.virtualcamera.Properties;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class MainWindow extends JFrame{


    public void MainWindow() {
        super.setTitle(Properties.MAIN_WINDOW_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
}
