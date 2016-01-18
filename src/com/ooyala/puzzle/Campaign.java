package com.ooyala.puzzle;

public class Campaign {

    private final String customer;
    private final int impressions;
    private final int revenue;

    public Campaign(String customer, int impressions, int revenue) {
        this.customer = customer;
        this.impressions = impressions;
        this.revenue = revenue;
    }

    public String getCustomer() {
        return customer;
    }

    public int getImpressions() {
        return impressions;
    }

    public int getRevenue() {
        return revenue;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", customer, impressions, revenue);
    }
}