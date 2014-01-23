package net.rendicahya.swing.components;

import net.rendicahya.commons.utils.RcStringUtils;

public class JIntegerTextField extends javax.swing.JTextField {

    public JIntegerTextField() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setText("0");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        setText(String.valueOf(RcStringUtils.extractInt(getText().trim())));
    }//GEN-LAST:event_formFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}