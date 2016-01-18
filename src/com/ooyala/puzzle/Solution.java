package com.ooyala.puzzle;

import java.util.Map;

public class Solution {

    private final Map<Campaign, Integer> combination;

    public Solution(Map<Campaign, Integer> combination) {
        this.combination = combination;
    }

    public void print() {

        Integer totalImpressions = 0;
        Integer totalRevenue = 0;

        for (Map.Entry<Campaign, Integer> entry : combination.entrySet()) {

            Campaign campaign = entry.getKey();
            Integer occurrences = entry.getValue();

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
