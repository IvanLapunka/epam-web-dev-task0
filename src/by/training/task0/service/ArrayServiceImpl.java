package by.training.task0.service;

import by.training.task0.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class ArrayServiceImpl implements ArrayService {

    private static Logger log = LogManager.getLogger();

    private static Random random = new Random();

    public Optional<Integer> getMin(CustomArray array) { // if the array is empty throw exception that can't find min in empty array
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return Optional.of(min);
    }

    public CustomArray replaceNegativeToZero(CustomArray array) {
        if (array == null) {
            return new CustomArray(0);
        }
        CustomArray arrayResult = new CustomArray(array.getArray());
        for (int i = 0; i < array.size(); i++) {
            if (arrayResult.get(i) < 0) {
                arrayResult.set(i, 0);
            }
        }
        return arrayResult;
    }

    public Optional<Integer> getMax(CustomArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        return Optional.of(max);
    }

    public Optional<Double> getAverage(CustomArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }
        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return Optional.of(sum / array.size());
    }

    public Optional<Integer> getSum(CustomArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return Optional.of(sum);
    }

    public Optional<Integer> getAmountPositive(CustomArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                sum++;
            }
        }
        return Optional.of(sum);
    }

    public Optional<Integer> getAmountNegative(CustomArray array) {
        if (array == null || array.size() == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < 0) {
                sum++;
            }
        }
        return Optional.of(sum);
    }

    public CustomArray sortInsertion(CustomArray array) {
        if (array == null) {
            return new CustomArray(0);
        }
        CustomArray newArray = new CustomArray(array.getArray());
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

    public CustomArray sortMerge(CustomArray array) {
        if (array == null) {
            return new CustomArray(0);
        }
        CustomArray newArray = new CustomArray(array.getArray());
        sortMerge(newArray, 0, array.size() - 1);
        return newArray;
    }

    private void sortMerge(CustomArray array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        sortMerge(array, left, middle);
        sortMerge(array, middle + 1, right);
        merge(array, left, middle, middle + 1, right);
    }

    private void merge(CustomArray array, int leftLeft, int leftRight, int rightLeft, int rightRight) {
        int ll = leftLeft;
        int[] buffer = new int[rightRight - leftLeft + 1];
        log.debug("ll " + leftLeft + " rr " + rightRight + " buffer " + buffer.length);
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

    public CustomArray sortQuick(CustomArray array) {
        if (array == null) {
            return new CustomArray(0);
        }
        CustomArray newArray = new CustomArray(array.getArray());
        sortQuick(newArray, 0, array.size() - 1);
        return newArray;
    }

    private void sortQuick(CustomArray array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = random.nextInt(right - left + 1) + left;
        log.debug("left: " + left + " | right " + right + " | random " + middle);
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

    private static void swap(CustomArray array, int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}
