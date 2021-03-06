package by.training.task0.service;

import by.training.task0.entity.CustomArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayServiceTest {

    ArrayService arrayService = new ArrayServiceImpl();

    @Test
    public void AmountOfPositiveNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = 3;
        OptionalInt result = arrayService.getAmountPositive(array);
        assertEquals(expect, result.getAsInt());
    }

    @Test
    public void AmountOfNegativeNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = 4;
        OptionalInt result = arrayService.getAmountNegative(array);
        assertEquals(expect, result.getAsInt());
    }

    @Test
    public void MinNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = -4;
        OptionalInt result = arrayService.getMin(array);
        assertEquals(expect, result.getAsInt());
    }

    @Test
    public void MaxNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = 3;
        OptionalInt result = arrayService.getMax(array);
        assertEquals(expect, result.getAsInt());
    }

    @Test
    public void ExchangeNegativeToZero() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int[] expect = {3, 2, 1, 0, 0, 0, 0, 0};
        CustomArray result = arrayService.replaceNegativeToZero(array);
        assertArrayEquals(expect, result.getArray());
    }

    @Test
    public void AverageNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        double expect = -0.5;
        OptionalDouble result = arrayService.getAverage(array);
        assertEquals(expect, result.getAsDouble());
    }

    @Test
    public void SumNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = -4;
        OptionalInt result = arrayService.getSum(array);
        assertEquals(expect, result.getAsInt());
    }

    @Test
    public void InsertionSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        Arrays.sort(given);
        CustomArray expectedArray = arrayService.sortInsertion(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void QuickSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        Arrays.sort(given);
        CustomArray expectedArray = arrayService.sortQuick(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void MergeSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        Arrays.sort(given);
        CustomArray expectedArray = arrayService.sortMerge(array);
        assertArrayEquals(given, expectedArray.getArray());
    }
}
