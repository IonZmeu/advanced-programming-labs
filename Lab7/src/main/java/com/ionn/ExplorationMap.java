package com.ionn;

import java.sql.Time;

public class ExplorationMap {
    private int n;
    private int k = 0;
    private final Cell[][] matrix;

    public ExplorationMap(int n) {
        this.n = n;
        matrix = new Cell[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = new Cell();
            }
        }
    }

    //Cell should be a wrapper or alias for List<Token>
    public synchronized boolean visit(int row, int col, Robot robot) {
        if (k == (n * n )) {
            robot.setRunning(false);
            return false;
        }

        Cell cell = matrix[row][col];
        if (!cell.isVisited()) {
            cell.setTokenList(robot.explore.mem.extractTokens(n));
            cell.setVisited(true);
//            System.out.println("success" + " " + k + " " + robot.getName());
            k++;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return matrix.toString();
    }
}
