package by.training.task0.validator;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTest {

    Validator validator = ValidatorImpl.getInstance();

    @Test
    public void ValidPositiveInteger() {
        String maxInt = String.valueOf(Integer.MAX_VALUE);
        assertTrue(validator.isIntegerType(maxInt));
    }

    @Test
    public void ValidNegativeInteger() {
        String maxInt = String.valueOf(Integer.MIN_VALUE);
        assertTrue(validator.isIntegerType(maxInt));
    }

    @Test
    public void NonValidNegativeInteger() {
        String maxInt = "-2147483649";
        assertFalse(validator.isIntegerType(maxInt));
    }

    @Test
    public void NonValidTooBigPositiveInteger() {
        String maxInt = "17236382872737473";
        assertFalse(validator.isIntegerType(maxInt));
    }

    @Test
    public void NonValidTooBigNegativeInteger() {
        String maxInt = "-17236382872737473";
        assertFalse(validator.isIntegerType(maxInt));
    }

    @Test
    public void NonValidInteger() {
        String maxInt = "-12s4f-73";
        assertFalse(validator.isIntegerType(maxInt));
    }

    @Test
    public void ValidStringIntegers() {
        String given = " 1 23 23413 12341 -345 0 ";
        assertTrue(validator.isIntegerNumbersArray(given));
    }

    @Test
    public void ValidBounderiesIntegers() {
        String given = new StringJoiner(" ")
                .add(Integer.MIN_VALUE + "")
                .add(Integer.MAX_VALUE + "")
                .toString();
        assertTrue(validator.isIntegerNumbersArray(given));
    }

}
