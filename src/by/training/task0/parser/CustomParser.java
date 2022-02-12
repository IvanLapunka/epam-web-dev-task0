package by.training.task0.parser;

import by.training.task0.validator.Validator;

import java.util.Optional;

public interface CustomParser {
    Optional<int[]> parseToIntArray(String sNumbers, Validator validator);
}
