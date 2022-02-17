package by.training.task0.parser;

import by.training.task0.validator.Validator;

import java.util.Optional;

/**
 * The data should be validated before parsing.
 * */
public class CustomParserImpl implements CustomParser{
    private static CustomParserImpl INSTANCE;

    private CustomParserImpl(){}

    public static CustomParserImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomParserImpl();
        }
        return INSTANCE;
    }

    @Override
    public Optional<int[]> parseToIntArray(String str, Validator validator) {
        String[] sNumbers = str.split(validator.DELIMITER);
        int[] array = new int[sNumbers.length];
        for (int i = 0; i < array.length; i++) {
            if (!validator.isIntegerType(sNumbers[i])) {
                return Optional.empty();
            }
            array[i] = Integer.parseInt(sNumbers[i]);
        }
        return Optional.of(array);
    }
}
