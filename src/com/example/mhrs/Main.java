package com.example.mhrs;

public class Main {
    public static void main(String[] args) {
        MHRS.initializeDoctors();
        javax.swing.SwingUtilities.invokeLater(MHRS::createAndShowGUI);
    }
}
