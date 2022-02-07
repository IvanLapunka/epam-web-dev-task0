package by.task0.array.service;

import by.task0.array.entity.Array;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ArrayService {

    private static Logger log = LogManager.getLogger();

    private static Random random = new Random();

    public static int getMin(Array array) { // if the array is empty throw exception that can't find min in empty array
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return min;
    }

    public static Array replaceNegativeToZero(Array array) {
        Array arrayResult = new Array(array.getArray());
        for (int i = 0; i < array.size(); i++) {
            if (arrayResult.get(i) < 0) {
                arrayResult.set(i, 0);
            }
        }
        return arrayResult;
    }

    public static int getMax(Array array) { // if the array is empty throw exception that can't find min in empty array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return max;
    }

    public static double getAverage(Array array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum / array.size(); // what if array has size 0
    }

    public static double getSum(Array array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum; // what if array has size 0
    }

    public static double getAmountPositive(Array array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                sum++;
            }
        }
        return sum; // what if array has size 0
    }

    public static double getAmountNegative(Array array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                sum++;
            }
        }
        return sum; // what if array has size 0
    }

    public static Array sortInsertion(Array array) {
        Array newArray = new Array(array.getArray());
        for (int i = 1; i < newArray.size(); i++) {
            int curr = newArray.get(i);
            int j = i;
            for (; j > 0 && newArray.get(j - 1) > curr; j--) {
                newArray.set(j, newArray.get(j - 1));
            }
            newArray.set(j, curr);
        }
        return newArray;
    }

    public static Array sortMerge(Array array) {
        Array newArray = new Array(array.getArray());
        sortMerge(newArray, 0, array.size() - 1);
        return newArray;
    }

    private static void sortMerge(Array array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        sortMerge(array, left, middle);
        sortMerge(array, middle + 1, right);
        merge(array, left, middle, middle + 1, right);
    }

    private static void merge(Array array, int leftLeft, int leftRight, int rightLeft, int rightRight) {
        int ll = leftLeft;
        int[] buffer = new int[rightRight - leftLeft + 1];
//        log.error("ll " + leftLeft + " rr " + rightRight + " buffer " + buffer.length);
        int i = 0;
        while (leftLeft <= leftRight && rightLeft <= rightRight) {
            if (array.get(rightLeft) < array.get(leftLeft)) {
                buffer[i] = array.get(rightLeft);
                rightLeft++;
            } else {
                buffer[i] = array.get(leftLeft);
                leftLeft++;
            }
            i++;
        }
        while (leftLeft <= leftRight) {
            buffer[i] = array.get(leftLeft);
            leftLeft++;
            i++;
        }
        while (rightLeft <= rightRight) {
            buffer[i] = array.get(rightLeft);
            rightLeft++;
            i++;
        }
        for (i = 0; i < buffer.length; i++) {
            array.set(ll + i, buffer[i]);
        }
        log.debug(Arrays.toString(array.getArray()));
    }

    public static Array sortQuick(Array array) {
        Array newArray = new Array(array.getArray());
        sortQuick(newArray, 0, array.size() - 1);
        return newArray;
    }

    private static void sortQuick(Array array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = random.nextInt(right - left + 1) + left;
        //log.log(Level.INFO, "left: " + left + " | right " + right + " | random " + middle);
        swap(array, middle, left);
        int compareElement = array.get(left);
        int indexMaxLessThenCompare = left;
        for (int i = left + 1; i <= right; i++) {
            if (array.get(i) < compareElement) {
                indexMaxLessThenCompare++;
                swap(array, i, indexMaxLessThenCompare);
            }
        }
        swap(array, left, indexMaxLessThenCompare);
        sortQuick(array, left, indexMaxLessThenCompare - 1);
        sortQuick(array, indexMaxLessThenCompare + 1, right);
    }

    private static void swap(Array array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}
