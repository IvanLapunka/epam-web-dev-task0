package by.training.task0.creator;

import by.training.task0.entity.CustomArray;
import by.training.task0.observer.ArrayObserver;
import by.training.task0.observer.ArrayObserverImpl;

import java.util.Random;

public class CustomArrayCreator {

    private static Integer counter = 1;

    ArrayObserver observer = new ArrayObserverImpl();
    private static final Random random = new Random();

    public CustomArray createCustomArray(int[] values) {
        CustomArray customArray = new CustomArray(values, counter);
        counter++;
        customArray.attach(observer);
        return customArray;
    }
}
