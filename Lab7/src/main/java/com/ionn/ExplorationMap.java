package com.ionn;

public class ExplorationMap {
    private int matrixDimension;
    private int visitedCells;
    private final Cell[][] matrix;

    public ExplorationMap(int matrixDimension) {
        this.matrixDimension = matrixDimension;
        matrix = new Cell[matrixDimension][matrixDimension];
        for (int row = 0; row < matrixDimension; row++) {
            for (int col = 0; col < matrixDimension; col++) {
                matrix[row][col] = new Cell();
            }
        }
    }

    public synchronized boolean visit(Robot robot) {
        for (int row = 0; row < matrixDimension; row++) {
            for (int col = 0; col < matrixDimension; col++) {
                Cell cell = matrix[row][col];
                if (!cell.isVisited()) {
                    visitedCells++;
                    //System.out.println("row: " + row + " col: " + col + " robot name: " + robot.getName());
                    cell.setVisited(true);
                    cell.setTokenList(robot.explore.mem.extractTokens(matrixDimension));
                    robot.addExtractedTokens(matrixDimension);
                    robot.setCurrentPositionX(row);
                    robot.setGetCurrentPositionY(col);
                    return true;
                }
                if (visitedCells == matrixDimension * matrixDimension) {
                    robot.setRunning(false);
                    return true;
                }
            }
        }

        return false;
    }

}
