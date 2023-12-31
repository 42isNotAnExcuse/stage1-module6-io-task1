package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] arr = getDataValues(getRawDataEntries(file));

        return new Profile(
                arr[0],
                Integer.parseInt(arr[1]),
                arr[2],
                Long.decode(arr[3]));
    }

    private String[] getRawDataEntries(File dataFile) {
        String[] arr = null;

        try (BufferedReader r = new BufferedReader(new java.io.FileReader(dataFile))) {
            arr = r.lines().toArray(String[]::new);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assert arr != null;
        return arr;
    }

    private String[] getDataValues(String[] data) {
        String[] arr = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            String s = data[i];
            arr[i] = s.substring(s.indexOf(' ') + 1);
        }
        return arr;
    }
}
