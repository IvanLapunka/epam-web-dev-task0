package by.task0.array.entity;

import java.util.Arrays;

public class Array {
    private int[] array;

    public Array(int[] array) {
        if (array == null) {
            this.array = new int[0];
        }
        this.array = array.clone();
    }

    public Array(int size) {
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
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
