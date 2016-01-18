package com.ooyala.puzzle;

import java.util.List;

public class Puzzle {

    private final int maxImpressions;
    private final List<Campaign> campaigns;

    public Puzzle(int maxImpressions, List<Campaign> campaigns) {
        this.maxImpressions = maxImpressions;
        this.campaigns = campaigns;
    }

    public int getMaxImpressions() {
        return maxImpressions;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    @Override
    public String toString() {
        return String.format("Puzzle -> \n\tMaxImpressions: %s\n\tCampaigns: %s", maxImpressions, campaigns);
    }
}
