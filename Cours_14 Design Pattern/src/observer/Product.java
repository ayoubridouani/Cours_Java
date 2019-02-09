package observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {

    private String name;

    private String availablity;

    private List<Observer> observerList;

    public Product(String name) {
        this.name = name;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer: observerList) {
            observer.update(availablity);
        }
    }

    public void setAvailablity(boolean available) {
        availablity = this.name + (available ? " Avaiable": " Not avaiable");
        notifyAllObservers();
    }
}
