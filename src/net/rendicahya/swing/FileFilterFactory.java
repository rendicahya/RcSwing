package net.rendicahya.swing;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileFilterFactory {

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

    /*
     * BINARY FILES
     */
    public static final int JAR_FILES = 41;

    private FileFilterFactory() {
    }

    public static FileFilter createFileFilter(int fileTypes) {
        switch (fileTypes) {
            case TEXT_FILES:
                return createFileFilter("Text Files", "txt");
            case JSON_FILES:
                return createFileFilter("JSON Files", "json");
            case MS_OFFICE_FILES:
                return createFileFilter("Microsoft Office Files", "doc", "docx", "xls", "xlsx", "ppt", "pptx");
            case MS_WORD_FILES:
                return createFileFilter("Microsoft Word Files", "doc", "docx");
            case MS_EXCEL_FILES:
                return createFileFilter("Microsoft Excel Files", "xls", "xlsx");
            case MS_POWERPOINT_FILES:
                return createFileFilter("Microsoft PowerPoint Files", "ppt", "pptx");
            case MS_ACCESS_FILES:
                return createFileFilter("Microsoft Access Files", "mdb", "mdbx");
            case PDF_FILES:
                return createFileFilter("Portable Document Files", "pdf");
            case JAVA_FILES:
                return createFileFilter("Java Files", "java");
            case PHP_FILES:
                return createFileFilter("PHP Files", "php");
            case IMAGE_FILES:
                return createFileFilter("Image Files", "jpg", "jpe", "jpeg", "jfif", "gif", "bmp", "png", "tif", "tiff");
            case JPEG_FILES:
                return createFileFilter("JPEG Images", "jpg", "jpe", "jpeg", "jfif");
            case GIF_FILES:
                return createFileFilter("GIF Images", "gif");
            case BMP_FILES:
                return createFileFilter("BMP Images", "bmp");
            case PNG_FILES:
                return createFileFilter("PNG Images", "png");
            case TIFF_FILES:
                return createFileFilter("TIFF Images", "tif", "tiff");
            case JAR_FILES:
                return createFileFilter("Java JAR Files", "jar");
            default:
                return null;
        }
    }

    public static FileFilter createFileFilter(final String description, final String... extensions) {
        return new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }

                String name = file.getName().toLowerCase();

                for (String ext : extensions) {
                    if (name.endsWith(ext)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public String getDescription() {
                StringBuilder filesOfType = new StringBuilder();
                int paramsLength = extensions.length;
                int i = 0;

                if (description != null) {
                    filesOfType.append(description);
                    filesOfType.append(" (");
                }

                while (i < paramsLength) {
                    filesOfType.append('*');

                    if (!extensions[i].startsWith(".")) {
                        filesOfType.append('.');
                    }

                    filesOfType.append(extensions[i]);

                    if (++i < paramsLength) {
                        filesOfType.append(", ");
                    }
                }

                if (description != null) {
                    filesOfType.append(')');
                }

                return filesOfType.toString();
            }
        };
    }
}
