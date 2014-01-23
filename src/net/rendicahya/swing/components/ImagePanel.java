package net.rendicahya.swing.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private int imageWidth;
    private int imageHeight;
    private double scale;

    public ImagePanel() {
        scale = 1;
        initComponents();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        if (image != null) {
            this.image = image;
            imageWidth = image.getWidth();
            imageHeight = image.getHeight();
        }
    }

    public void setScale(double scale) {
        this.scale = scale;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image != null) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            double x = (getWidth() - scale * imageWidth) / 2;
            double y = (getHeight() - scale * imageHeight) / 2;
            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            at.scale(scale, scale);
            g2.drawRenderedImage(image, at);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (image != null) {
            int w = (int) (scale * image.getWidth());
            int h = (int) (scale * image.getHeight());

            return new Dimension(w, h);
        } else {
            return new Dimension(getWidth(), getHeight());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
