package com.auroratracker.desktop.view;

import com.auroratracker.desktop.controller.AuroraDataController;
import com.auroratracker.desktop.model.AuroraData;

import javax.swing.*;
import java.awt.*;

public class AuroraTrackerDesktopApp {
    private final AuroraDataController dataController;
    private JTextArea dataArea;
    private JButton refreshButton;

    public AuroraTrackerDesktopApp() {
        this.dataController = new AuroraDataController(); // Initiera controller

        // Bygg GUI
        JFrame frame = new JFrame("AuroraTracker Desktop");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // TextArea för data
        dataArea = new JTextArea();
        dataArea.setEditable(false);
        frame.add(new JScrollPane(dataArea), BorderLayout.CENTER);

        // Uppdateringsknapp
        refreshButton = new JButton("Uppdatera Data");
        refreshButton.addActionListener(e -> fetchAndDisplayData());
        frame.add(refreshButton, BorderLayout.SOUTH);

        // Visa fönster
        frame.setVisible(true);

        // Ladda data vid start
        fetchAndDisplayData();
    }

    private void fetchAndDisplayData() {
        SwingUtilities.invokeLater(() -> {
            try {
                AuroraData data = dataController.fetchAuroraData();
                dataArea.setText(formatAuroraData(data));
            } catch (Exception e) {
                dataArea.setText("Ett fel uppstod: " + e.getMessage());
            }
        });
    }

    private String formatAuroraData(AuroraData data) {
        return String.format(
                "Kp-index: %.1f\n" +
                        "Solvindshastighet: %.1f km/s\n" +
                        "Solvindtäthet: %.1f partiklar/cm³\n" +
                        "IMF Bz: %.1f nT\n" +
                        "Dst: %.1f nT\n" +
                        "Analys: %s",
                data.getKpIndex(),
                data.getSolarWindSpeed(),
                data.getSolarWindDensity(),
                data.getImfBz(),
                data.getDst(),
                data.getAnalysis()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AuroraTrackerDesktopApp::new);
    }
}
