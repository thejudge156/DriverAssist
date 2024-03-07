package me.judge.driverassist;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.ds.ipcam.IpCamDriver;
import com.github.sarxos.webcam.ds.ipcam.IpCamStorage;

import javax.swing.*;

public class DriverAssist {
    static {
        Webcam.setDriver(new IpCamDriver(new IpCamStorage("cameras.xml")));
    }

    public static void main(String[] args) {
        final Webcam webcam = Webcam.getDefault();
        final WebcamPanel panel = new WebcamPanel(webcam);

        JFrame f = new JFrame("Driver Assist");
        f.add(panel);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(320, 240);

        panel.start();
    }
}
