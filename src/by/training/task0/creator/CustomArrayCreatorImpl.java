package by.training.task0.creator;

import by.training.task0.entity.CustomArray;

public class CustomArrayCreatorImpl implements CustomArrayCreator{
    
    @Override
    public CustomArray createCustomArray(int[] values) {
        return new CustomArray(values);
    }
}
