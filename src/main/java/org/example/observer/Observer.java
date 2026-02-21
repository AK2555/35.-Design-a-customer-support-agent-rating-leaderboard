package org.example.observer;

import org.example.entities.Agent;
import org.example.entities.Rating;

public interface Observer {
    void update(Agent agent, Rating rating);
}
