package by.training.task0.repository.specification;

import by.training.task0.entity.CustomArray;

public class AllPositiveSpecification implements Specification {
    @Override
    public boolean specified(CustomArray customArray) {
        for (int i : customArray.getArray()) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
