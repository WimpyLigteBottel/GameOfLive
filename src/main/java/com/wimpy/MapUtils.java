package com.wimpy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MapUtils {

    public static boolean ENABLE_CONSOLE_PRINTING = false;


    public static String printMap(boolean[][] map) {

        StringBuilder sb = new StringBuilder();

        for (int hight = 0; hight < map.length; hight++) {
            for (int width = 0; width < map.length; width++) {
                boolean b = map[width][hight];

                sb.append(getCell(b)).append(" ");
                if (ENABLE_CONSOLE_PRINTING)
                    System.out.print(getCell(b) + " ");
            }
            sb.append("\n");
            if (ENABLE_CONSOLE_PRINTING)
                System.out.println();
        }

        return sb.toString();
    }

    public static boolean[][] readMap(Path path) {

        try {
            List<String> lines = Files.readAllLines(path);
            int actualWidth = lines.get(0).replaceAll(" ", "").length() + 1;
            boolean[][] map = new boolean[actualWidth][actualWidth];


            for (int i = 0; i < lines.size(); i++) {

                String line = lines.get(i);

                String[] s = line.split(" ");

                for (int width = 0; width < s.length; width++) {
                    if (s[width].equals("1")) {
                        map[width][i] = true;
                    }
                }

            }

            return map;

        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Failed to generate map");

    }


    private static String getCell(boolean cell) {
        return cell ? "X" : ".";

    }


}
