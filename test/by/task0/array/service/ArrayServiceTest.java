package by.task0.array.service;

import by.task0.array.entity.Array;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayServiceTest {

    @Test
    public void testAmountOfPositiveNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int expect = 3;
        assertEquals(expect, ArrayService.getAmountPositive(array));
    }

    @Test
    public void testAmountOfNegativeNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int expect = 3;
        assertEquals(expect, ArrayService.getAmountPositive(array));
    }

    @Test
    public void testMinNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int expect = -3;
        assertEquals(expect, ArrayService.getMin(array));
    }

    @Test
    public void testMaxNumbers() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int expect = 3;
        assertEquals(expect, ArrayService.getMax(array));
    }

    @Test
    public void testExchangeNegativeToZero() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int[] expect = {3, 2, 1, 0, 0, 0, 0};
        Array result = ArrayService.replaceNegativeToZero(array);
        assertArrayEquals(expect, result.getArray());
    }

    @Test
    public void testAverageNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int expect = 0;
        assertEquals(expect, ArrayService.getAverage(array));
    }

    @Test
    public void testSumNumber() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        int expect = 0;
        assertEquals(expect, ArrayService.getSum(array));
    }

    @Test
    public void testInsertionSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        Arrays.sort(given);
        Array expectedArray = ArrayService.sortInsertion(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void testQuickSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        Arrays.sort(given);
        Array expectedArray = ArrayService.sortQuick(array);
        assertArrayEquals(given, expectedArray.getArray());
    }

    @Test
    public void testMergeSort() {
        int[] given = {3, 2, 1, 0, -1, -2, -3};
        Array array = new Array(given);
        Arrays.sort(given);
        Array expectedArray = ArrayService.sortMerge(array);
        assertArrayEquals(given, expectedArray.getArray());
    }
}
