package by.training.task0.creator;

import by.training.task0.entity.CustomArray;
import by.training.task0.exception.CustomException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomArrayCreatorTest {

    CustomArrayCreator creator = new CustomArrayCreator();

    @Test
    void createCustomArray() throws CustomException {
        int size = 10;
        final CustomArray customArray = creator.createCustomArray(creator.intArrayGenerator(10));
        assertNotNull(customArray.getId());
    }

    @Test
    void createRandomlyGeneratedCustomArrayList() throws CustomException {
        int size = 10;
        int capacity = 10;
        final List<CustomArray> randomlyGeneratedCustomArrayList = creator.createRandomlyGeneratedCustomArrayList(size, capacity);
        assertEquals(size, randomlyGeneratedCustomArrayList.size());
        final Set<Integer> ids = randomlyGeneratedCustomArrayList.stream()
                .map(CustomArray::getId)
                .collect(Collectors.toSet());
        assertEquals(size, ids.size());
    }

    @Test
    void intArrayGenerator() throws CustomException {
        int size = 3;
        final int[] ints = creator.intArrayGenerator(size);
        assertEquals(size, ints.length);
    }
}