package com.ooyala.puzzle;

import java.util.Map;

public class Solution {

    private final Map<Campaign, Integer> combination;

    public Solution(Map<Campaign, Integer> combination) {
        this.combination = combination;
    }

    public void print() {

        // TODO: Adjust output to match the criteria
        combination.entrySet().stream().forEach(e -> {

            Campaign c = e.getKey();
            Integer occurrences = e.getValue();

            String output = String.format("%s,%d,%d,%d", c.getCustomer(), occurrences, c.getImpressions() * occurrences,
                    c.getRevenue() * occurrences);

            System.out.println(output);
        });
    }
}
