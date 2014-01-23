package net.rendicahya.swing.components;

import javax.swing.JTextField;
import net.rendicahya.commons.utils.RcStringUtils;

public class JRupiahTextField extends JTextField {

    public JRupiahTextField() {
        initComponents();
    }

    public int getValue() {
        return RcStringUtils.extractInt(getText().trim());
    }

    public void setValue(int value) {
        setText(RcStringUtils.formatRupiah(value));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        setText("Rp 0");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        if (isEditable()) {
            setText(String.valueOf(RcStringUtils.extractInt(getText().trim())));
        }

        selectAll();
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        setValue(getValue());
    }//GEN-LAST:event_formFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
