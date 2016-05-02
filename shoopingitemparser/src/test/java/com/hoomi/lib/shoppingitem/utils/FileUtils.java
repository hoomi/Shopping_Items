package com.hoomi.lib.shoppingitem.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class FileUtils {

    public static String readFile(String filePath) {
        File file = new File(filePath);
        String readValue = "";
        if (file.exists() && file.canRead()) {
            try {
                List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(file.getAbsolutePath()));
                for (String s: lines) {
                    readValue += s;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return readValue;
    }
}
