package org.example;

import org.example.manager.AgentRatingManager;
import org.example.manager.AverageRatingManager;
import org.example.manager.BestAgentByMonthManager;

import java.util.ArrayList;
import java.util.List;

public class AgentRatingLeaderboard {

    private AgentRatingManager agentRatingManager;
    private AverageRatingManager averageRatingManager;
    private BestAgentByMonthManager bestAgentByMonthManager;

    public AgentRatingLeaderboard() {
        this.agentRatingManager=new AgentRatingManager();
        this.averageRatingManager=new AverageRatingManager();
        this.bestAgentByMonthManager=new BestAgentByMonthManager();
        this.agentRatingManager.addObserver(averageRatingManager);
        this.agentRatingManager.addObserver(bestAgentByMonthManager);
    }

    public void rateAgent(String agentName, int rating, String date) {
         agentRatingManager.rateAgent(agentName,rating,date);
    }

    public List<String> getAverageRatings() {
       return averageRatingManager.getAverageRatings();
    }

    public List<String> getBestAgentsByMonth(String month) {
        return bestAgentByMonthManager.getBestAgentsByMonth(month);
    }
}