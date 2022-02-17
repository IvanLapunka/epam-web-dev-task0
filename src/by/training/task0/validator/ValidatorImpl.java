package by.training.task0.validator;

import java.math.BigInteger;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public enum ValidatorImpl implements Validator {
    INSTANCE;

    private static final String NUMBER_INTEGER_REGEX = "-?\\d+";
    private static final String NUMBERS_INTEGER_REGEX = "^( *-?\\d+ *)+$";
    private static final Pattern patternNumberInteger = Pattern.compile(NUMBER_INTEGER_REGEX);
    private static final Pattern patternRowOfNumbers = Pattern.compile(NUMBERS_INTEGER_REGEX);

    @Override
    public boolean isIntegerType(String value) {
        if(!patternNumberInteger.matcher(value).matches()) {
            return false;
        }

        BigInteger test = new BigInteger(value);
        BigInteger result = BigInteger.valueOf(test.intValue());
        return test.equals(result);
    }

    @Override
    public boolean isIntegerNumbersArray(String value) {
        return patternRowOfNumbers.matcher(value).matches();
    }
}