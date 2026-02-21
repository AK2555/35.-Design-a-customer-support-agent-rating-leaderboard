package org.example;

import java.util.*;

import java.util.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        AgentRatingLeaderboard leaderboard = new AgentRatingLeaderboard();

        // March ratings
        leaderboard.rateAgent("Alice", 5, "2025-03-12");
        leaderboard.rateAgent("Bob", 4, "2025-03-10");
        leaderboard.rateAgent("Alice", 4, "2025-03-13");
        leaderboard.rateAgent("Bob", 5, "2025-03-22");
        leaderboard.rateAgent("Charlie", 3, "2025-03-05");
        leaderboard.rateAgent("Charlie", 4, "2025-03-06");
        leaderboard.rateAgent("Dora", 5, "2025-03-01");
        leaderboard.rateAgent("Dora", 4, "2025-03-02");
        leaderboard.rateAgent("Dora", 2, "2025-03-03");
        leaderboard.rateAgent("Dora", 4, "2025-03-04");
        leaderboard.rateAgent("bob", 5, "2025-03-07");      // lowercase (distinct)
        leaderboard.rateAgent("ALICE", 3, "2025-03-08");    // uppercase (distinct)
        leaderboard.rateAgent("Zack", 4, "2025-03-09");
        leaderboard.rateAgent("Zack", 4, "2025-03-10");
        leaderboard.rateAgent("Zack", 4, "2025-03-11");

        // February ratings
        leaderboard.rateAgent("Alice", 4, "2025-02-20");
        leaderboard.rateAgent("Bob", 5, "2025-02-01");
        leaderboard.rateAgent("Bob", 3, "2025-02-05");
        leaderboard.rateAgent("Charlie", 2, "2025-02-14");
        leaderboard.rateAgent("Anna", 4, "2025-02-10");
        leaderboard.rateAgent("Anna", 4, "2025-02-11");
        leaderboard.rateAgent("Anny", 4, "2025-02-12");
        leaderboard.rateAgent("Zed", 4, "2025-02-13");
        leaderboard.rateAgent("Zed", 5, "2025-02-14");
        leaderboard.rateAgent("Zed", 3, "2025-02-15");

        // January rating
        leaderboard.rateAgent("Dora", 5, "2025-01-15");

        // Get Average Ratings
        System.out.println("=== Average Ratings ===");
        List<String> result = leaderboard.getAverageRatings();

        for (String entry : result) {
            System.out.println(entry);
        }
    }
}
 //[bob,5.0, Alice,4.3, Bob,4.3, Anna,4.0, Anny,4.0, Dora,4.0, Zack,4.0, Zed,4.0, ALICE,3.0, Charlie,3.0]