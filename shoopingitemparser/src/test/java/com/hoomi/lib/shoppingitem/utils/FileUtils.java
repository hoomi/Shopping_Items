package com.hoomi.lib.shoppingitem.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class FileUtils {

    public static String readFile(String filePath) {
        File file = new File(filePath);
        final String[] readValue = {""};
        if (file.exists() && file.canRead()) {
            try {
                Files.lines(FileSystems.getDefault().getPath(file.getAbsolutePath())).forEach(s -> readValue[0] += s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return readValue[0];
    }
}
