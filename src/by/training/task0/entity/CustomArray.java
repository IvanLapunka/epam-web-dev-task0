package by.training.task0.entity;

import by.training.task0.observer.ArrayObserver;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray extends AbstractCustomArray{
    private static int counter = 1;
    private int[] array;

    public CustomArray(int[] array) {
        if (array == null) {
            this.array = new int[0];
        }
        this.array = array.clone();
        this.id = counter;
        counter++;
    }

    public CustomArray(int size) {
        array = new int[size];
    }

    public int[] getArray() {
        return array.clone();
    }

    public int size() {
        return array.length;
    }

    public int get(int index) {
        return array[index];
    }

    public void set(int index, int value) {
        array[index] = value;
        notifyAllObservers();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ", "{", "}");
        return sj.add(this.getClass().getSimpleName())
                .add(" array = ")
                .add(Arrays.toString(array)).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public void notifyAllObservers() {
        for (ArrayObserver observer: observers) {
            observer.changeElement(this);
        }
    }
}
