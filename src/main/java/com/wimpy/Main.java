package com.wimpy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    GameOfLive game = new GameOfLive();

    public static void main(String[] args) {
        try {
            new Main();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Main() throws IOException, InterruptedException {


        String backspace = "\\\\";
        String baseDir = System.getProperty("user.dir").replaceAll(backspace, "/");
        boolean[][] map = MapUtils.readMap(Paths.get(baseDir + "/gridmap"));

        String resultsPath = baseDir + "/results";
        File file = new File(resultsPath);
        file.mkdir();


        for (int i = 0; i < 1000; i++) {
            String fileName = resultsPath + "/result-" + i + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                map = game.process(map);
                bw.write(MapUtils.printMap(map));
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
