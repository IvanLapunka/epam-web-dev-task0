package by.training.task0.repository;

import by.training.task0.creator.CustomArrayCreator;
import by.training.task0.entity.CustomArray;
import by.training.task0.entity.comparator.SizeArrayComparator;
import by.training.task0.exception.CustomException;
import by.training.task0.repository.specification.impl.SumIsPositiveSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayRepositoryImplTest {
    private static Logger log = LogManager.getLogger();

    CustomArrayRepository repository = CustomArrayRepositoryImpl.getInstance();
    CustomArrayCreator creator = new CustomArrayCreator();

    @BeforeEach
    public void clearRepository() {
        repository.queryAll()
                .forEach(repository::removeCustomArray);
    }

    @Test
    void addCustomArray() throws CustomException{
        int[] array = creator.intArrayGenerator(10);
        final CustomArray customArray = creator.createCustomArray(array);
        repository.addCustomArray(customArray);
        final Optional<CustomArray> first = repository.query((Predicate<CustomArray>) arr -> arr.getId().equals(customArray.getId()))
                .stream()
                .findFirst();
        assertEquals(customArray, first.get());
    }

    @Test
    void removeCustomArray() throws CustomException {
        int[] array = creator.intArrayGenerator(10);
        final CustomArray customArray = creator.createCustomArray(array);
        repository.addCustomArray(customArray);
        log.info("The size of repository is " + repository.queryAll().size());
        repository.removeCustomArray(customArray);
        assertEquals(repository.queryAll().size(), 0);
    }

    @Test
    void addAllCustomArray() throws CustomException {
        final List<CustomArray> randomlyGeneratedCustomArrayList = creator.createRandomlyGeneratedCustomArrayList(10, 10);
        repository.addAllCustomArray(randomlyGeneratedCustomArrayList);
        for (CustomArray array: randomlyGeneratedCustomArrayList) {
            final CustomArray customArray = repository.query((Predicate<CustomArray>) ar -> ar.getId().equals(array.getId())).stream()
                    .findFirst().get();
            log.info(customArray);
            assertEquals(array, customArray);
        }
    }

    @Test
    void querySpecification() {
        int[] ar = {0, 1, 2, 3};
        final CustomArray customArray = creator.createCustomArray(ar);
        repository.addCustomArray(customArray);
        final CustomArray result = repository.query(new SumIsPositiveSpecification()).get(0);

        assertEquals(customArray, result);
    }

    @Test
    void queryAll() throws CustomException {
        final List<CustomArray> randomlyGeneratedCustomArrayList = creator.createRandomlyGeneratedCustomArrayList(10, 10);
        repository.addAllCustomArray(randomlyGeneratedCustomArrayList);
        final List<CustomArray> customArrays = repository.queryAll();
        assertEquals(randomlyGeneratedCustomArrayList, customArrays);
    }

    @Test
    void sort() {
        List<CustomArray> source = List.of(
                creator.createCustomArray(new int[] {4, 3, 2, 1})
                , creator.createCustomArray(new int[] {3, 2, 1})
                , creator.createCustomArray(new int[] {2, 1})
                , creator.createCustomArray(new int[] {1})
        );
        final ArrayList<CustomArray> forTest = new ArrayList<>(source);
        repository.addAllCustomArray(forTest);

        List<CustomArray> target = new ArrayList<>(List.of(
                new CustomArray(new int[] {4, 3, 2, 1})
                , new CustomArray(new int[] {3, 2, 1})
                , new CustomArray(new int[] {2, 1})
                , new CustomArray(new int[] {1})
        ));
        Collections.sort(target, new SizeArrayComparator());
        assertEquals(target, repository.sort(new SizeArrayComparator()));
    }
}