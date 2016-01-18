package com.ooyala.puzzle;

import com.ooyala.helpers.GCDHelper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solver {

    private final Puzzle puzzle;

    public Solver(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Solution solve() {

        Integer maxImpressions = puzzle.getMaxImpressions();
        List<Campaign> campaigns = puzzle.getCampaigns();

        // STEP 1: If we can find a common divider, we may reduce the problem space
        List<Integer> impressionList = campaigns.stream().map(Campaign::getImpressions).collect(Collectors.toList());
        Integer gcd = new GCDHelper().calculate(maxImpressions, impressionList);

        // Init two arrays, one to keep track of best profit for a certain volume
        int[] profit = new int[maxImpressions / gcd + 1]; // Store profit for a certain volume
        int[] campaignIndexAtVolume = new int[maxImpressions / gcd + 1]; // Store index of campaign last added

        // STEP 2: Generate data used to draw a decision
        IntStream.range(0, maxImpressions / gcd + 1).forEach(i -> campaignIndexAtVolume[i] = Integer.MIN_VALUE);
        IntStream.range(0, campaigns.size()).forEach(i -> {

            Integer revenue = campaigns.get(i).getRevenue();
            Integer impressions = campaigns.get(i).getImpressions() / gcd; // Don't forget optimization

            IntStream.rangeClosed(impressions, maxImpressions / gcd).forEach(j -> {

                Integer option = profit[j - impressions] + revenue;

                if (option >= profit[j]) { // We just found a better alternative
                    profit[j] = option;
                    campaignIndexAtVolume[j] = i; // Save the index of the campaign that provided better profit
                }
            });
        });

        Map<Campaign, Integer> combination = new HashMap<>();
        campaigns.stream().forEach(c -> combination.put(c, 0)); // Default to 0 occurrences

        // STEP 3: Backtrack, resolve which campaigns that are part of the optimal combination
        Integer capacity = maxImpressions / gcd;
        while (capacity > 0) {

            Integer campaignIndex = campaignIndexAtVolume[capacity];
            if (campaignIndex == Integer.MIN_VALUE) { // Nothing to do here, move on
                capacity--;
                continue;
            }

            Campaign campaign = campaigns.get(campaignIndex);
            combination.put(campaign, combination.get(campaign) + 1); // Update occurrences
            capacity -= campaign.getImpressions() / gcd; // Don't forget our optimization
        }

        return new Solution(puzzle, combination);
    }
}
