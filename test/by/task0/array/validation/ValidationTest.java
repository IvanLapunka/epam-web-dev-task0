package by.task0.array.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    public void testValidPositiveInteger() {
        String maxInt = String.valueOf(Integer.MAX_VALUE);
        assertTrue(Validation.isInteger(maxInt));
    }

    @Test
    public void testValidNegativeInteger() {
        String maxInt = String.valueOf(Integer.MIN_VALUE);
        assertTrue(Validation.isInteger(maxInt));
    }

    @Test
    public void testNonValidNegativeInteger() {
        String maxInt = "-2147483649";
        assertFalse(Validation.isInteger(maxInt));
    }

    @Test
    public void testNonValidTooBigPositiveInteger() {
        String maxInt = String.valueOf("17236382872737473");
        assertFalse(Validation.isInteger(maxInt));
    }

    @Test
    public void testNonValidTooBigNegativeInteger() {
        String maxInt = String.valueOf("-17236382872737473");
        assertFalse(Validation.isInteger(maxInt));
    }

    @Test
    public void testNonValidInteger() {
        String maxInt = String.valueOf("-12s4f-73");
        assertFalse(Validation.isInteger(maxInt));
    }

}
