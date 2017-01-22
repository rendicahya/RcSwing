package net.rendicahya.swing.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class JFileChooserUtils {

    private static final String LAST_DIRECTORY_ITEM = "last_directory";
    private static final Map<JFileChooser, PropertiesConfiguration> CONFIGURATION_MAP = new HashMap<>();

    private JFileChooserUtils() {
    }

    public static void rememberLastDirectory(JFileChooser jFileChooser, String configurationFile) throws ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration(configurationFile);

        CONFIGURATION_MAP.put(jFileChooser, configuration);
    }

    public static void open(JFileChooser jFileChooser, Runnable callback) {
        if (jFileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        callback.run();
    }

    public static void open(JFileChooser jFileChooser, boolean useConfiguration, Runnable callback) throws ConfigurationException {
        if (useConfiguration && CONFIGURATION_MAP.containsKey(jFileChooser)) {
            PropertiesConfiguration configuration = CONFIGURATION_MAP.get(jFileChooser);
            String lastDirectory = configuration.getString(LAST_DIRECTORY_ITEM);
            File lastDirectoryFile = new File(lastDirectory);

            if (lastDirectoryFile.exists()) {
                jFileChooser.setCurrentDirectory(lastDirectoryFile);
            }
        }

        if (jFileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        if (useConfiguration && CONFIGURATION_MAP.containsKey(jFileChooser)) {
            PropertiesConfiguration configuration = CONFIGURATION_MAP.get(jFileChooser);
            String lastDirectory = jFileChooser.getSelectedFile().getParent();

            configuration.setProperty(LAST_DIRECTORY_ITEM, lastDirectory);
            configuration.save();
        }

        callback.run();
    }

    public static void save(JFileChooser fileChooser, Runnable action) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            action.run();
        }
    }
}
