package com.eddie;

import com.eddie.helpers.InputHelper;
import com.eddie.puzzle.Puzzle;
import com.eddie.puzzle.Solution;
import com.eddie.puzzle.Solver;

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
