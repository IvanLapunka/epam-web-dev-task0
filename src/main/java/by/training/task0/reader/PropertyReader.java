package by.training.task0.reader;

import by.training.task0.exception.CustomException;

public interface PropertyReader {
    String getPropertyValue(String propertyKey) throws CustomException;
}
