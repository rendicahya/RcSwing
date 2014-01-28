package net.rendicahya.swing.utils;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;

public class FrameUtils {

    private FrameUtils() {
    }

    public static void centerFrame(Window window) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dim.width - window.getSize().width) / 2, (dim.height - window.getSize().height) / 2);
    }

    protected void maximizeFrame(Frame frame) {
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
