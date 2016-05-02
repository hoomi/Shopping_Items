package com.hoomi.lib.shoppingitem.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class FileReadingUtils {

    public static String readFile(String filePath) {
        String readValue="";
            try {
                InputStream in = FileReadingUtils.class.getResourceAsStream("/proper_response.html");
                readValue = convertStreamToString(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return readValue;
    }

    public static String convertStreamToString(InputStream is) throws IOException {
        int k;
        StringBuffer sb=new StringBuffer();
        while((k=is.read()) != -1)
        {
            sb.append((char)k);
        }
        return sb.toString();
    }
}
