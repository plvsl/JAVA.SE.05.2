package main;

import java.io.*;
import java.util.*;

public class UniversalClass {
    private static Map<String, String> storage = new HashMap();
    private static Set<String> filePaths = new HashSet<>();

    public static boolean importProperties(String filePath) throws IOException {
        Properties prop = new Properties();
        File file = new File(filePath);
        filePath = file.getCanonicalPath();
        InputStream input;
        if (!filePaths.add(filePath)) {
            return false;
        }

        try {
            input = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            return false;
        }

        prop.load(input);

        for (String propertyKey : prop.stringPropertyNames()) {
            String value = prop.getProperty(propertyKey);
            storage.put(propertyKey, value);
        }
        return true;
    }

    public static String getValueByKey(String key) throws KeyNotFoundException {
        String result;
        if (!storage.containsKey(key)) {
            throw new KeyNotFoundException("key not found");
        }
        result = storage.get(key);
        return result;
    }
}