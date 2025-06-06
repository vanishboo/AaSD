package ru.itis.aads.lab;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] map = {
                {4, 5, 1, 1},
                {1, 1, 2, 3},
                {1, 2, 1, 3},
                {1, 10, 1, 1}
        };
        System.out.println(task3(map));
    }

    public static int task3(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int[][] points = new int[n][m];
        points[0][0] = map[0][0];
        
        for (int j = 1; j < m; j++) {
            points[0][j] = points[0][j - 1] + map[0][j];
        }

        for (int i = 1; i < n; i++) {
            points[i][0] = points[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                points[i][j] = Math.min(points[i - 1][j], points[i][j - 1]) + map[i][j];
            }
        }

        return points[n - 1][m - 1];
    }
}
