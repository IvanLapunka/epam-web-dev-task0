package by.training.task0.entity.comparator;

import by.training.task0.entity.CustomArray;

import java.util.Comparator;

public class SizeArrayComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.size() - o2.size();
    }
}
