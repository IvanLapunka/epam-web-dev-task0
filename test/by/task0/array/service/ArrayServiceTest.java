package by.task0.array.service;

import by.task0.array.entity.Array;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayServiceTest {

    @Test
    public void testAmountOfPositiveNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        int expect = 3;
        Optional<Integer> result = ArrayService.getAmountPositive(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testAmountOfNegativeNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        int expect = 4;
        Optional<Integer> result = ArrayService.getAmountNegative(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testMinNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        int expect = -4;
        Optional<Integer> result = ArrayService.getMin(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testMaxNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        int expect = 3;
        Optional<Integer> result = ArrayService.getMax(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testExchangeNegativeToZero() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        int[] expect = {3, 2, 1, 0, 0, 0, 0, 0};
        Array result = ArrayService.replaceNegativeToZero(array);
        assertArrayEquals(expect, result.getArray());
    }

    @Test
    public void testAverageNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        double expect = -0.5;
        Optional<Double> result = ArrayService.getAverage(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testSumNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        int expect = -4;
        Optional<Integer> result = ArrayService.getSum(array);
        assertEquals(expect, result.get());
    }

    @Test
    public void testInsertionSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        Arrays.sort(given);
        Array expectedArray = ArrayService.sortInsertion(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void testQuickSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        Arrays.sort(given);
        Array expectedArray = ArrayService.sortQuick(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void testMergeSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3, -4};
        Array array = new Array(given);
        Arrays.sort(given);
        Array expectedArray = ArrayService.sortMerge(array);
        assertArrayEquals(given, expectedArray.getArray());
    }
}
