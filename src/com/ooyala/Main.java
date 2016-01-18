package com.ooyala;

import com.ooyala.helpers.InputHelper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            throw new IOException();
        }

        Puzzle puzzle = InputHelper.readFromFile(args[0]);
        Solver solver = new Solver(puzzle);
        Solution solution = solver.solve();

        solution.print();
    }
}
