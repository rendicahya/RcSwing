package net.rendicahya.swing.components;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class JFileChooser extends javax.swing.JFileChooser {

    /*
     * PLAIN
     */
    public static final int TEXT_FILES = 0;
    public static final int JSON_FILES = 1;

    /*
     * DOCUMENTS
     */
    public static final int MS_OFFICE_FILES = 11;
    public static final int MS_WORD_FILES = 12;
    public static final int MS_EXCEL_FILES = 13;
    public static final int MS_POWERPOINT_FILES = 14;
    public static final int MS_ACCESS_FILES = 15;
    public static final int PDF_FILES = 16;

    /*
     * SOURCE CODE
     */
    public static final int JAVA_FILES = 21;
    public static final int PHP_FILES = 22;

    /*
     * IMAGES
     */
    public static final int IMAGE_FILES = 31;
    public static final int JPEG_FILES = 32;
    public static final int GIF_FILES = 33;
    public static final int BMP_FILES = 34;
    public static final int PNG_FILES = 35;
    public static final int TIFF_FILES = 36;

    public JFileChooser() {
        initComponents();
    }

    public void setFileFilter(int fileTypes) {
        switch (fileTypes) {
            case TEXT_FILES:
                setFileFilter("Text Files", "txt");
                break;
            case JSON_FILES:
                setFileFilter("JSON Files", "json");
                break;
            case MS_OFFICE_FILES:
                setFileFilter("Microsoft Office Files", "doc", "docx", "xls", "xlsx", "ppt", "pptx");
                break;
            case MS_WORD_FILES:
                setFileFilter("Microsoft Word Files", "doc", "docx");
                break;
            case MS_EXCEL_FILES:
                setFileFilter("Microsoft Excel Files", "xls", "xlsx");
                break;
            case MS_POWERPOINT_FILES:
                setFileFilter("Microsoft PowerPoint Files", "ppt", "pptx");
                break;
            case MS_ACCESS_FILES:
                setFileFilter("Microsoft Access Files", "mdb", "mdbx");
                break;
            case PDF_FILES:
                setFileFilter("Portable Document Files", "pdf");
                break;
            case JAVA_FILES:
                setFileFilter("Java Files", "java");
                break;
            case PHP_FILES:
                setFileFilter("PHP Files", "php");
                break;
            case IMAGE_FILES:
                setFileFilter("Image Files", "jpg", "jpe", "jpeg", "jfif", "gif", "bmp", "png", "tif", "tiff");
                break;
            case JPEG_FILES:
                setFileFilter("JPEG Images", "jpg", "jpe", "jpeg", "jfif");
                break;
            case GIF_FILES:
                setFileFilter("GIF Images", "gif");
                break;
            case BMP_FILES:
                setFileFilter("BMP Images", "bmp");
                break;
            case PNG_FILES:
                setFileFilter("PNG Images", "png");
                break;
            case TIFF_FILES:
                setFileFilter("TIFF Images", "tif", "tiff");
                break;
        }
    }

    public void setFileFilter(final String description, final String... extension) {
        setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }

                String name = file.getName().toLowerCase();

                for (String ext : extension) {
                    if (name.endsWith(ext)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public String getDescription() {
                StringBuilder filesOfType = new StringBuilder();
                int paramsLength = extension.length;
                int i = 0;

                if (description != null) {
                    filesOfType.append(description);
                    filesOfType.append(" (");
                }

                while (i < paramsLength) {
                    filesOfType.append('*');

                    if (!extension[i].startsWith(".")) {
                        filesOfType.append('.');
                    }

                    filesOfType.append(extension[i]);

                    if (++i < paramsLength) {
                        filesOfType.append(", ");
                    }
                }

                if (description != null) {
                    filesOfType.append(')');
                }

                return filesOfType.toString();
            }
        });
    }

    public void open(Runnable action) {
        if (super.showOpenDialog(null) == APPROVE_OPTION) {
            action.run();
        }
    }

    public void save(Runnable action) {
        if (super.showSaveDialog(null) == APPROVE_OPTION) {
            action.run();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
