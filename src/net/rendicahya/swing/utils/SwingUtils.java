package net.rendicahya.swing.utils;

import ij.ImagePlus;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;
import net.rendicahya.swing.ChangeListener;

public class SwingUtils {

    private SwingUtils() {
    }

    public static void clear(JTextComponent... fields) {
        for (JTextComponent field : fields) {
            field.setText("");
        }
    }

    public static void clear(JLabel... fields) {
        for (JLabel field : fields) {
            field.setText("");
        }
    }

    public static void fillWith(String value, JTextComponent... fields) {
        for (JTextComponent field : fields) {
            field.setText(value);
        }
    }

    public static void disable(Component... components) {
        for (Component component : components) {
            component.setEnabled(false);
        }
    }

    public static void enable(Component... components) {
        for (Component component : components) {
            component.setEnabled(true);
        }
    }

    public static void setUneditable(JTextComponent... components) {
        for (JTextComponent component : components) {
            component.setEditable(false);
        }
    }

    public static void setEditable(JTextComponent... components) {
        for (JTextComponent component : components) {
            component.setEditable(true);
        }
    }

    public static void setFocusable(Component... components) {
        for (Component component : components) {
            component.setFocusable(true);
        }
    }

    public static void setUnfocusable(Component... components) {
        for (Component component : components) {
            component.setFocusable(false);
        }
    }

    public static void show(Component... components) {
        for (Component component : components) {
            component.setVisible(true);
        }
    }

    public static void hide(Component... components) {
        for (Component component : components) {
            component.setVisible(false);
        }
    }

    public static boolean isSelected(AbstractButton... buttons) {
        for (AbstractButton button : buttons) {
            if (button.isSelected()) {
                return true;
            }
        }

        return false;
    }

    public static void addChangeListener(ChangeListener listener, JTextComponent... components) {
        for (JTextComponent component : components) {
            component.getDocument().addDocumentListener(listener);
        }
    }

    public static void addActionListener(ActionListener listener, AbstractButton... buttons) {
        for (AbstractButton button : buttons) {
            button.addActionListener(listener);
        }
    }

    public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public static void setImage(Image image, JLabel label) {
        label.setIcon(new ImageIcon(image));
    }

    public static void setImage(ImagePlus image, JLabel label) {
        setImage(image.getImage(), label);
    }

    /**
     * Should be called before initComponents()
     *
     * @param lafName
     */
    public static void setLaf(String lafName) {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals(lafName)) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }
                break;
            }
        }
    }
}
