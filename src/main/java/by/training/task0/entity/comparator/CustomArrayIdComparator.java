package by.training.task0.entity.comparator;

import by.training.task0.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        if (o1.getId() == null) {
            return -1;
        } else if (o2.getId() == null) {
            return 1;
        }
        return o1.getId() - o2.getId();
    }
}
