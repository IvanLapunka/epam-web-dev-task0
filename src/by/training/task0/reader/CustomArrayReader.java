package by.training.task0.reader;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import by.training.task0.validator.Validator;

import java.util.List;
import java.util.Optional;

public interface CustomArrayReader {
    Optional<CustomArray> readFirstValid(String filePath, Validator validator) throws CustomException;
    Optional<List<CustomArray>> readAllValidRows(String filePath, Validator validator) throws CustomException;
}
