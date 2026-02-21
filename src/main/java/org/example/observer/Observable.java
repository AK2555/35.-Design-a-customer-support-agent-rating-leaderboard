package org.example.observer;

import org.example.entities.Agent;
import org.example.entities.Rating;

public interface Observable {
    void addObserver(Observer observer);
    void notifyAllObservers(Agent agent, Rating rating);
}
