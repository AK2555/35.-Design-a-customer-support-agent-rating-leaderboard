package org.example.manager;

import org.example.entities.Agent;
import org.example.entities.Rating;
import org.example.observer.Observable;
import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AgentRatingManager implements Observable {
    private Map<String, Agent> agentMap;
    private List<Observer> observers;

    public AgentRatingManager(){
        agentMap=new HashMap<>();
        observers=new ArrayList<>();
    }

    public void rateAgent(String agentName, int rating, String date) {
        if(!agentMap.containsKey(agentName)){
            agentMap.put(agentName,new Agent(agentName));
        }
        Agent agent=agentMap.get(agentName);
        Rating ratingObj=new Rating(rating,date);
        agent.addRatingToAgentRatingList(ratingObj);
        notifyAllObservers(agent,ratingObj);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers(Agent agent, Rating rating) {
       for(Observer observer: observers){
           observer.update(agent,rating);
       }
    }
}
