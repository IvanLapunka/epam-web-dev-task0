package by.training.task0.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationTest {

    Validator validator = ValidatorImpl.INSTANCE;

    @Test
    public void testValidPositiveInteger() {
        String maxInt = String.valueOf(Integer.MAX_VALUE);
        assertTrue(validator.isInteger(maxInt));
    }

    @Test
    public void testValidNegativeInteger() {
        String maxInt = String.valueOf(Integer.MIN_VALUE);
        assertTrue(validator.isInteger(maxInt));
    }

    @Test
    public void testNonValidNegativeInteger() {
        String maxInt = "-2147483649";
        assertFalse(validator.isInteger(maxInt));
    }

    @Test
    public void testNonValidTooBigPositiveInteger() {
        String maxInt = "17236382872737473";
        assertFalse(validator.isInteger(maxInt));
    }

    @Test
    public void testNonValidTooBigNegativeInteger() {
        String maxInt = "-17236382872737473";
        assertFalse(validator.isInteger(maxInt));
    }

    @Test
    public void testNonValidInteger() {
        String maxInt = "-12s4f-73";
        assertFalse(validator.isInteger(maxInt));
    }

}