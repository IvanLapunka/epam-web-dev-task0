package by.training.task0.service;

import by.training.task0.entity.CustomArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayServiceTest {

    ArrayService arrayService = new ArrayServiceImpl();

    @Test
    public void testAmountOfPositiveNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = 3;
        Optional<Integer> result = arrayService.getAmountPositive(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testAmountOfNegativeNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = 4;
        Optional<Integer> result = arrayService.getAmountNegative(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testMinNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = -4;
        Optional<Integer> result = arrayService.getMin(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testMaxNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = 3;
        Optional<Integer> result = arrayService.getMax(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testExchangeNegativeToZero() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int[] expect = {3, 2, 1, 0, 0, 0, 0, 0};
        CustomArray result = arrayService.replaceNegativeToZero(array);
        assertArrayEquals(expect, result.getArray());
    }

    @Test
    public void testAverageNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        double expect = -0.5;
        Optional<Double> result = arrayService.getAverage(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testSumNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        int expect = -4;
        Optional<Integer> result = arrayService.getSum(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testInsertionSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        Arrays.sort(given);
        CustomArray expectedArray = arrayService.sortInsertion(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void testQuickSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        Arrays.sort(given);
        CustomArray expectedArray = arrayService.sortQuick(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void testMergeSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        CustomArray array = new CustomArray(given);
        Arrays.sort(given);
        CustomArray expectedArray = arrayService.sortMerge(array);
        assertArrayEquals(given, expectedArray.getArray());
    }
}
