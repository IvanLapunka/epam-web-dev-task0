package by.training.task0.reader.impl;

import by.training.task0.exception.CustomException;
import by.training.task0.reader.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertyReaderPlainImpl implements PropertyReader {
    private static Logger log = LogManager.getLogger();
    private Properties properties;
    private final String fileName;

    public PropertyReaderPlainImpl(String fileName) {
        this.fileName = fileName;
    }

    public String getPropertyValue(String propertyKey) throws CustomException {
        if (properties == null || properties.isEmpty()) {
            readPropertyFile();
        }
        return properties.getProperty(propertyKey);
    }

    private void readPropertyFile() throws CustomException {
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final URL resource = contextClassLoader.getResource("");
        final String path = resource.getPath();
        try (FileReader fileReader = new FileReader(path + this.fileName)) {
            properties = new Properties();
            properties.load(fileReader);
        } catch (IOException e) {
            log.error("Something get wrong during opening file: " + fileName);
            throw new CustomException(e);
        }
    }
}
