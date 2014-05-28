package net.rendicahya.swing.utils;

import javax.swing.JFileChooser;

public class JFileChooserUtils {

    private JFileChooserUtils() {
    }

    public static void open(JFileChooser fileChooser, Runnable action) {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            action.run();
        }
    }

    public static void save(JFileChooser fileChooser, Runnable action) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            action.run();
        }
    }
}
