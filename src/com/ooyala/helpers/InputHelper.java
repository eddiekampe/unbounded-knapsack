package com.ooyala.helpers;

import com.ooyala.puzzle.Campaign;
import com.ooyala.puzzle.Puzzle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputHelper {

    public static Puzzle readFromFile(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        Integer maxImpressions = 0;
        List<Campaign> campaigns = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {
            List<String> linesAsString = lines.collect(Collectors.toList());

            for (String line : linesAsString) {
                String[] campaignDetails = line.split(","); // Expecting either 0 or 2 commas

                if (campaignDetails.length == 1) {
                    maxImpressions = Integer.parseInt(campaignDetails[0]);
                }
                else if (campaignDetails.length == 3) {
                    String campaignName = campaignDetails[0];
                    int impressions = Integer.parseInt(campaignDetails[1]);
                    int revenue = Integer.parseInt(campaignDetails[2]);

                    campaigns.add(new Campaign(campaignName, impressions, revenue));
                }
            }
        }

        return new Puzzle(maxImpressions, campaigns);
    }
}
