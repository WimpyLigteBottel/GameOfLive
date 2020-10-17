package com.wimpy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    GameOfLive game = new GameOfLive();

    public static void main(String[] args) {
        try {
            new Main();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Main() throws IOException, InterruptedException {


        Path path = Paths.get("G:\\Code repositery\\GameOfLiveJava\\src\\main\\resources\\gridmap");


        boolean[][] map = MapUtils.readMap(path);


        for (int i = 0; i < 1000; i++) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\Code repositery\\GameOfLiveJava\\results\\result-" + i + ".txt"))) {
                map = game.process(map);
                bw.write(MapUtils.printMap(map));
            } catch (IOException e) {

            }
        }


    }
}
