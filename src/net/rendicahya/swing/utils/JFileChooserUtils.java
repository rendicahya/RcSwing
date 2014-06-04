package net.rendicahya.swing.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class JFileChooserUtils {

    private static final String LAST_DIRECTORY_ITEM = "last_directory";
    private static final Map<JFileChooser, PropertiesConfiguration> configurationMap;

    static {
        configurationMap = new HashMap<>();
    }

    private JFileChooserUtils() {
    }

    public static void rememberLastDirectory(JFileChooser jFileChooser, String configurationFile) throws ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration(configurationFile);

        configurationMap.put(jFileChooser, configuration);
    }

    public static void open(JFileChooser jFileChooser, Runnable action) throws ConfigurationException {
        if (configurationMap.containsKey(jFileChooser)) {
            PropertiesConfiguration configuration = configurationMap.get(jFileChooser);
            String lastDirectory = configuration.getString(LAST_DIRECTORY_ITEM);
            File lastDirectoryFile = new File(lastDirectory);

            if (lastDirectoryFile.exists()) {
                jFileChooser.setCurrentDirectory(lastDirectoryFile);
            }
        }

        if (jFileChooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        if (configurationMap.containsKey(jFileChooser)) {
            PropertiesConfiguration configuration = configurationMap.get(jFileChooser);
            String lastDirectory = jFileChooser.getSelectedFile().getParent();

            configuration.setProperty(LAST_DIRECTORY_ITEM, lastDirectory);
            configuration.save();
        }

        action.run();
    }

    public static void save(JFileChooser fileChooser, Runnable action) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            action.run();
        }
    }
}
