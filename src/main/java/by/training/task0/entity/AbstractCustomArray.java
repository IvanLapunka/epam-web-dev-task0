package by.training.task0.entity;

import by.training.task0.observer.ArrayObserver;
import by.training.task0.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCustomArray implements Observable {
    private List<ArrayObserver> observers = new ArrayList<>();
    private Integer id;

    public AbstractCustomArray(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<ArrayObserver> getObservers() {
        return observers;
    }

    @Override
    public void attach(ArrayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.removeIf(o -> o.equals(observer));
    }

    @Override
    public abstract void notifyAllObservers();
}
