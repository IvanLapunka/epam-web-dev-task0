package by.training.task0.observer;

import by.training.task0.entity.ArrayStatistics;
import by.training.task0.entity.CustomArray;
import by.training.task0.entity.Warehouse;
import by.training.task0.service.ArrayService;
import by.training.task0.service.ArrayServiceImpl;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayObserverImpl implements ArrayObserver{
    @Override
    public void changeElement(CustomArray array) {
        ArrayService arrayService = new ArrayServiceImpl();
        final OptionalInt sum = arrayService.getSum(array);
        final OptionalInt min = arrayService.getMin(array);
        final OptionalInt max = arrayService.getMax(array);
        final OptionalDouble average = arrayService.getAverage(array);
        ArrayStatistics statistics = new ArrayStatistics(
                min.getAsInt()
                ,max.getAsInt()
                ,sum.getAsInt()
                ,average.getAsDouble()
        );
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.replace(array.getId(), statistics);
    }
}
