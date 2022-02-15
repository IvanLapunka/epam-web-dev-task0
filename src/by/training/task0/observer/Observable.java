package by.training.task0.observer;

import by.training.task0.entity.ArrayStatistics;

public interface Observable {
    void attach(ArrayObserver observer);
    void detach(ArrayObserver observer);
    void notifyAllObservers();
}
