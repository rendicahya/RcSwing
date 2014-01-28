package net.rendicahya.swing.utils;

import javax.swing.JOptionPane;

public class DialogUtils {

    private DialogUtils() {
    }

    public static boolean confirm(String message) {
        return confirm(message, "Confirmation");
    }

    public static boolean confirm(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
    }

    public static String input(String message, Object initialSelectionValue) {
        return JOptionPane.showInputDialog(null, message, initialSelectionValue);
    }

    public static String input(String message) {
        return input(message, "Input");
    }

    public static String input(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

    public static void warn(String message) {
        warn(message, "Warning");
    }

    public static void warn(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void inform(String message) {
        inform(message, "Information");
    }

    public static void inform(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String message) {
        inform(message, "Error");
    }

    public static void error(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
