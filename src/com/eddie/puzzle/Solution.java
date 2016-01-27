package com.eddie.puzzle;

import java.util.Map;

public class Solution {

    private final Puzzle puzzle;
    private final Map<Campaign, Integer> combination;

    public Solution(Puzzle puzzle, Map<Campaign, Integer> combination) {
        this.puzzle = puzzle;
        this.combination = combination;
    }

    public void print() {

        Integer totalImpressions = 0;
        Integer totalRevenue = 0;

        for (Campaign campaign : puzzle.getCampaigns()) {

            Integer occurrences = combination.get(campaign);

            totalImpressions += campaign.getImpressions() * occurrences;
            totalRevenue += campaign.getRevenue() * occurrences;

            System.out.println(String.format("%s,%d,%d,%d", campaign.getCustomer(),
                                                            occurrences,
                                                            campaign.getImpressions() * occurrences,
                                                            campaign.getRevenue() * occurrences));
        }

        System.out.println(String.format("%d,%d", totalImpressions, totalRevenue));
    }
}
