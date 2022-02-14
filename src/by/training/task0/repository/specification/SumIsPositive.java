package by.training.task0.repository.specification;

import by.training.task0.entity.CustomArray;

public class SumIsPositive implements Specification {
    @Override
    public boolean specified(CustomArray customArray) {
        int sum = 0;
        for (int i : customArray.getArray()) {
            sum += i;
        }
        return sum > 0;
    }
}
