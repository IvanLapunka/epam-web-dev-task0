package by.training.task0.observer;

import by.training.task0.configurator.CustomArrayConfigurator;
import by.training.task0.creator.CustomArrayCreator;
import by.training.task0.entity.ArrayStatistics;
import by.training.task0.entity.CustomArray;
import by.training.task0.entity.Warehouse;
import by.training.task0.repository.CustomArrayRepository;
import by.training.task0.repository.CustomArrayRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverImplTest {

    CustomArrayRepository repository = CustomArrayRepositoryImpl.getInstance();

    @Test
    void changeElement() {
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArrayConfigurator configurator = new CustomArrayConfigurator();
        List<CustomArray> list = new ArrayList<>(List.of(
                creator.createCustomArray(new int[]{0, 0, 0, 0})
        ));
        repository.addAllCustomArray(list);
        configurator.fillWarehouse();
        Warehouse warehouse = Warehouse.getInstance();
        final CustomArray customArray = list.get(0);
        customArray.set(0, 4);
        int expectedAvg = 1;
        final ArrayStatistics statistics = warehouse.get(customArray.getId());
        assertEquals(1D, statistics.getAverage());
    }
}