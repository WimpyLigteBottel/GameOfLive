package com.wimpy;

import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    public GameOfLife() {
    }

    public boolean[][] process(boolean[][] currentMap) {

        boolean[][] newMap = new boolean[currentMap.length][currentMap.length];


        for (int y = 0; y < newMap.length; y++) {

            for (int x = 0; x < newMap.length; x++) {

                boolean alive = isAlive(currentMap, new Point(x, y));


                List<Boolean> cellsAroundAlive = Arrays.asList(
                        isUpAlive(currentMap, new Point(x, y)), // N
                        isUpRightAlive(currentMap, new Point(x, y)), // NE
                        isLeftAlive(currentMap, new Point(x, y)), // E
                        isDownRightAlive(currentMap, new Point(x, y)), // SE
                        isDownAlive(currentMap, new Point(x, y)), // S
                        isDownLeftAlive(currentMap, new Point(x, y)), // SW
                        isRightAlive(currentMap, new Point(x, y)), // W
                        isUpLeftAlive(currentMap, new Point(x, y)) // NW
                );


                newMap[x][y] = checkIfILive(alive, cellsAroundAlive);


            }
        }


        return newMap;
    }

    public boolean checkIfILive(boolean isCurrentCellAlive, List<Boolean> countOfCellsAround) {
        int alive = (int) countOfCellsAround.stream().filter(bool -> bool).count();

        if (isCurrentCellAlive) {
            switch (alive) {
                case 2:
                case 3:
                    //Any live cell with two or three live neighbours lives on to the next generation.
                    return true;
                default:
                    //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                    //Any live cell with more than three live neighbours dies, as if by overpopulation.
                    return false;
            }
        } else {
            //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            return alive == 3;
        }


    }

    public boolean isAlive(boolean[][] currentMap, Point current) {

        return currentMap[current.x][current.y];
    }


    public boolean isRightAlive(boolean[][] currentMap, Point current) {
        current.RIGHT();

        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }


    public boolean isLeftAlive(boolean[][] currentMap, Point current) {
        current.LEFT();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }

    public boolean isUpAlive(boolean[][] currentMap, Point current) {
        current.UP();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }

    public boolean isUpLeftAlive(boolean[][] currentMap, Point current) {
        current.UP();
        current.LEFT();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }

    public boolean isUpRightAlive(boolean[][] currentMap, Point current) {
        current.UP();
        current.RIGHT();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }

    public boolean isDownAlive(boolean[][] currentMap, Point current) {
        current.DOWN();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }


    public boolean isDownLeftAlive(boolean[][] currentMap, Point current) {
        current.DOWN();
        current.LEFT();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }

    public boolean isDownRightAlive(boolean[][] currentMap, Point current) {
        current.DOWN();
        current.RIGHT();
        if (isOutOfBounds(current, currentMap)) return false;
        return currentMap[current.x][current.y];
    }

    private boolean isOutOfBounds(Point current, boolean[][] currentMap) {
        if (current.x < 0 || current.y < 0) {
            return true;
        }

        if (current.x >= currentMap.length || current.y >= currentMap.length) {
            return true;
        }
        return false;
    }


    public static class Point {

        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public void UP() {
            this.y -= 1;
        }


        public void DOWN() {
            this.y += 1;
        }


        public void LEFT() {
            this.x -= 1;
        }


        public void RIGHT() {
            this.x += 1;
        }


    }
}
