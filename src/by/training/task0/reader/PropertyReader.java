package by.training.task0.reader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertyReader {
    public static String getPropertyValue(String propertyFile, String propertyKey) throws IOException {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final URL resource = contextClassLoader.getResource("");
        final String path = resource.getPath();
        FileReader fileReader = new FileReader(path + propertyFile);
        Properties p = new Properties();
        p.load(fileReader);
        return p.getProperty(propertyKey);
    }
}
