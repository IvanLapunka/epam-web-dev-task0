package by.task0.array.validation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Validation {
    private static final int MAX_INT_VALUE_LENGTH = ("" + Integer.MAX_VALUE).length();
    private static final int MIN_INT_VALUE_LENGTH = ("" + Integer.MIN_VALUE).length();
    private static final String STRING_MAX_INTEGER = "" + Integer.MAX_VALUE;
    private static final String STRING_MIN_INTEGER = "" + Integer.MIN_VALUE;

    public static boolean isInteger(String value) {
        char[] cValue = value.toCharArray();
        int i = 0;
        boolean isNegative = false;
        if (cValue[0] == '-') {
            i = 1;
            isNegative = true;
        }
        while (i < cValue.length) {
            if (!Character.isDigit(cValue[i])) {
                return false;
            }
            i++;
        }
        if (isNegative){
            return value.length() < MIN_INT_VALUE_LENGTH
                    || (value.length() == MIN_INT_VALUE_LENGTH && value.compareTo(STRING_MIN_INTEGER) <= 0);
        }
        return value.length() < MAX_INT_VALUE_LENGTH
                || (value.length() <= MAX_INT_VALUE_LENGTH && value.compareTo(STRING_MAX_INTEGER) <= 0);
    }

    //faster than implemented above version. Is it correct to write like this?
    public static boolean isIntegerWithTry(String value) {
        try {
            int tmp = Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}