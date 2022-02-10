package by.training.task0.validator;

import java.math.BigInteger;
import java.util.regex.Pattern;

public enum ValidatorImpl implements Validator {
    INSTANCE;

    private static final Pattern pattern = Pattern.compile("-?\\d+");

    @Override public boolean isInteger(String value) {
        if (!pattern.matcher(value).matches()) {
            return false;
        }

        BigInteger test = new BigInteger(value);
        int result = test.intValue();
        return test.toString().equals(result + "");
    }
}