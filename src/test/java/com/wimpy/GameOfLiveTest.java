package com.wimpy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLiveTest {

    private static final String basePath = "G:\\Code repositery\\GameOfLiveJava\\src\\test\\resources\\";


    private GameOfLive gameOfLive = new GameOfLive();

    @Test
    public void testprocess_allDead() {

        boolean[][] expected = new boolean[10][10];
        boolean[][] newLife = gameOfLive.process(expected);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testprocess_block() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "block"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "block"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testprocess_beehive() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "bee-hive"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "bee-hive"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testprocess_boat() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "boat"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "boat"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testprocess_tub() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "tub"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "tub"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testprocess_loaf() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "loaf"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "loaf"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }


    @Test
    public void testprocess_blinker() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "blinker_1"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "blinker_2"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testprocess_beacon() {

        boolean[][] block = MapUtils.readMap(Paths.get(basePath + "beacon_1"));
        boolean[][] expected = MapUtils.readMap(Paths.get(basePath + "beacon_2"));

        boolean[][] newLife = gameOfLive.process(block);


        assertEquals(MapUtils.printMap(expected), MapUtils.printMap(newLife));

    }

    @Test
    public void testCheckIfILive() {

        assertFalse(gameOfLive.checkIfILive(false, Arrays.asList(false, false, false, false)));
        assertFalse(gameOfLive.checkIfILive(true, Arrays.asList(false, false, false, false)));
        assertFalse(gameOfLive.checkIfILive(true, Arrays.asList(true, false, false, false)));
        assertTrue(gameOfLive.checkIfILive(true, Arrays.asList(true, true, false, false)));
        assertTrue(gameOfLive.checkIfILive(true, Arrays.asList(true, true, true, false)));
        assertFalse(gameOfLive.checkIfILive(true, Arrays.asList(true, true, true, true)));

    }

    @Test
    public void testisAlive() {
        boolean[][] map = new boolean[10][10];
        map[0][0] = true;

        assertFalse(gameOfLive.isAlive(map, new GameOfLive.Point(1, 1)));
        assertTrue(gameOfLive.isAlive(map, new GameOfLive.Point(0, 0)));
    }

    @Test
    public void testisRightAlive() {

        boolean[][] map = new boolean[10][10];
        map[5][5] = true;

        assertTrue(gameOfLive.isRightAlive(map, new GameOfLive.Point(4, 5)));
        assertFalse(gameOfLive.isRightAlive(map, new GameOfLive.Point(5, 5)));
    }


    @Test
    public void testisLeftAlive() {
        boolean[][] map = new boolean[10][10];
        map[0][1] = true;

        assertTrue(gameOfLive.isLeftAlive(map, new GameOfLive.Point(1, 1)));
        assertFalse(gameOfLive.isLeftAlive(map, new GameOfLive.Point(5, 5)));
    }

    @Test
    public void testisUpAlive() {


        boolean[][] map = new boolean[10][10];
        map[1][0] = true;

        assertTrue(gameOfLive.isUpAlive(map, new GameOfLive.Point(1, 1)));
        assertFalse(gameOfLive.isUpAlive(map, new GameOfLive.Point(5, 5)));

    }


    @Test
    public void testisDownAlive() {


        boolean[][] map = new boolean[10][10];
        map[1][1] = true;

        MapUtils.printMap(map);

        assertTrue(gameOfLive.isDownAlive(map, new GameOfLive.Point(1, 0)));
        assertFalse(gameOfLive.isDownAlive(map, new GameOfLive.Point(5, 5)));

    }

}