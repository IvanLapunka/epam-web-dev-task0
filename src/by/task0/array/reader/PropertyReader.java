package by.task0.array.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String getPropertyValue(String propertyFile, String propertyKey) throws IOException {
        final String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        FileReader fileReader = new FileReader(path + propertyFile);
        Properties p = new Properties();
        p.load(fileReader);
        return p.getProperty(propertyKey);
    }
}
