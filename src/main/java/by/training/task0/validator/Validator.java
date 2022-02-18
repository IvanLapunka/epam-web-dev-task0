package by.training.task0.validator;

public interface Validator {
    String DELIMITER = " +";

    boolean isIntegerType(String value);
    boolean isIntegerNumbersArray(String value);
}
