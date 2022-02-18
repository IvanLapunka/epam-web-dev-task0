package by.training.task0.entity;

import java.util.StringJoiner;

public class ArrayStatistics {
    private int min;
    private int max;
    private int sum;
    private double average;

    public ArrayStatistics(int min, int max, int sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    @Override
    public String toString() {
        return new StringJoiner("","ArrayStatistics{","}")
                .add(", min=").add(min + "")
                .add(", max=").add(max + "")
                .add(", sum=").add(sum + "")
                .add(", average=").add(average + "")
                .toString();
    }
}
