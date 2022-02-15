package by.training.task0.configurator;

import by.training.task0.entity.ArrayStatistics;
import by.training.task0.entity.CustomArray;
import by.training.task0.entity.Warehouse;
import by.training.task0.repository.CustomArrayRepository;
import by.training.task0.repository.CustomArrayRepositoryImpl;
import by.training.task0.repository.specification.AllElements;
import by.training.task0.service.ArrayService;
import by.training.task0.service.ArrayServiceImpl;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class CustomArrayConfigurator {
    public void fillWarehouse() {
        Warehouse warehouse = Warehouse.getInstance();
        CustomArrayRepository repository = CustomArrayRepositoryImpl.getInstance();
        final List<CustomArray> query = repository.query(new AllElements());
        query.forEach(array -> warehouse.add(array.getId(), getArrayStatistics(array)));
    }

    private ArrayStatistics getArrayStatistics(CustomArray array) {
        ArrayService arrayService = new ArrayServiceImpl();
        final OptionalInt sum = arrayService.getSum(array);
        final OptionalInt min = arrayService.getMin(array);
        final OptionalInt max = arrayService.getMax(array);
        final OptionalDouble average = arrayService.getAverage(array);
        return new ArrayStatistics(
                min.getAsInt()
                ,max.getAsInt()
                ,sum.getAsInt()
                ,average.getAsDouble()
        );
    }
}
