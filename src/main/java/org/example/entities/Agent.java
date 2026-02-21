package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agent {
    private final String id;
    private String agentName;
    private List<Rating> ratingList;

    public Agent(String agentName){
        this.id= UUID.randomUUID().toString();
        this.agentName=agentName;
        ratingList=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public void addRatingToAgentRatingList(Rating rating){
        this.ratingList.add(rating);
    }
}
