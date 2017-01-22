package net.rendicahya.swing.components;

import ij.ImagePlus;
import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RcImageZoomPanel extends JPanel {

    public RcImageZoomPanel() {
        initComponents();

        addZoomListener(() -> {
            if (pnlImage.getImage() != null) {
                double scale = (double) sldZoom.getValue() / 10;
                pnlImage.setScale(scale);
            }
        });
    }

    public BufferedImage getImage() {
        return pnlImage.getImage();
    }

    public void setImage(ImagePlus image) {
        setImage(image.getBufferedImage());
    }

    public void setImage(BufferedImage image) {
        pnlImage.setImage(image);
        repaint();

        for (ChangeListener listener : sldZoom.getChangeListeners()) {
            listener.stateChanged(null);
        }
    }

    public final void addZoomListener(final Runnable zoomListener) {
        if (zoomListener != null) {
            sldZoom.addChangeListener((ChangeEvent evt) -> {
                zoomListener.run();
            });
        }
    }

    public void syncZoomWith(final RcImageZoomPanel mate) {
        if (mate != null) {
            addZoomListener(() -> {
                mate.setZoomScale(getZoomScale());
            });

            mate.addZoomListener(() -> {
                setZoomScale(mate.getZoomScale());
            });
        }
    }

    public int getZoomScale() {
        return sldZoom.getValue();
    }

    public void setZoomScale(int zoomScale) {
        sldZoom.setValue(zoomScale);
    }

    public int getVerticalScrollPosition() {
        return scrollPane.getVerticalScrollBar().getValue();
    }

    public void setVerticalScrollPosition(int position) {
        scrollPane.getVerticalScrollBar().setValue(position);
    }

    public int getHorizontalScrollPosition() {
        return scrollPane.getHorizontalScrollBar().getValue();
    }

    public void setHorizontalScrollPosition(int position) {
        scrollPane.getHorizontalScrollBar().setValue(position);
    }

    public void addVerticalScrollListener(final Runnable verticalScrollListener) {
        if (verticalScrollListener != null) {
            scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    if (e.getAdjustable().getOrientation() == Adjustable.VERTICAL) {
                        verticalScrollListener.run();
                    }
                }
            });
        }
    }

    public void syncVerticalScrollWith(final RcImageZoomPanel mate) {
        if (mate != null) {
            addVerticalScrollListener(() -> {
                mate.setVerticalScrollPosition(getVerticalScrollPosition());
            });

            mate.addVerticalScrollListener(() -> {
                setVerticalScrollPosition(mate.getVerticalScrollPosition());
            });
        }
    }

    public void addHorizontalScrollListener(final Runnable horizontalScrollListener) {
        if (horizontalScrollListener != null) {
            scrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    if (e.getAdjustable().getOrientation() == Adjustable.HORIZONTAL) {
                        horizontalScrollListener.run();
                    }
                }
            });
        }
    }

    public void syncHorizontalScrollWith(final RcImageZoomPanel mate) {
        if (mate != null) {
            addHorizontalScrollListener(() -> {
                mate.setHorizontalScrollPosition(getHorizontalScrollPosition());
            });

            mate.addHorizontalScrollListener(() -> {
                setHorizontalScrollPosition(mate.getHorizontalScrollPosition());
            });
        }
    }

    public void syncScrollWith(RcImageZoomPanel mate) {
        syncVerticalScrollWith(mate);
        syncHorizontalScrollWith(mate);
    }

    public void syncWith(RcImageZoomPanel mate) {
        syncZoomWith(mate);
        syncScrollWith(mate);
    }

    public void syncWith(RcImageZoomPanel... mates) {
        for (RcImageZoomPanel mate : mates) {
            syncWith(mate);
        }
    }

    public ImagePanel getImagePanel() {
        return pnlImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sldZoom = new javax.swing.JSlider();
        scrollPane = new javax.swing.JScrollPane();
        pnlImage = new net.rendicahya.swing.components.ImagePanel();
        jLabel1 = new javax.swing.JLabel();

        sldZoom.setMaximum(30);
        sldZoom.setMinimum(1);
        sldZoom.setValue(10);
        sldZoom.setFocusable(false);

        pnlImage.setFocusable(false);
        pnlImage.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                pnlImageMouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout pnlImageLayout = new javax.swing.GroupLayout(pnlImage);
        pnlImage.setLayout(pnlImageLayout);
        pnlImageLayout.setHorizontalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        pnlImageLayout.setVerticalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(pnlImage);

        jLabel1.setText("Zoom:");
        jLabel1.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldZoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlImageMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_pnlImageMouseWheelMoved
        if (pnlImage.getImage() != null) {
            setZoomScale(getZoomScale() - evt.getWheelRotation());
        }
    }//GEN-LAST:event_pnlImageMouseWheelMoved
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private net.rendicahya.swing.components.ImagePanel pnlImage;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSlider sldZoom;
    // End of variables declaration//GEN-END:variables
}
