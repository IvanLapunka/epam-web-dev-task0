package by.training.task0.creator;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import by.training.task0.observer.ArrayObserver;
import by.training.task0.observer.ArrayObserverImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomArrayCreator {

    private static Integer counter = 1;
    private static final Random random = new Random();

    ArrayObserver observer = new ArrayObserverImpl();

    public CustomArray createCustomArray(int[] values) {
        CustomArray customArray = new CustomArray(values, counter);
        counter++;
        customArray.attach(observer);
        return customArray;
    }

    public List<CustomArray> createRandomlyGeneratedCustomArrayList(int listSize, int maxArraySize) throws CustomException {
        if (listSize < 0) {
            throw new CustomException("It is not possible generate negative amount of items.");
        }
        List<CustomArray> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            int[] tmp = intArrayGenerator(maxArraySize);
            list.add(createCustomArray(tmp));
        }
        return list;
    }

    public int[] intArrayGenerator(int arraySize) throws CustomException {
        if (arraySize < 0) {
            throw new CustomException("The size of array should be non negative");
        }
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
