package ru.itis.aads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        list.add(Collections.emptyList());
        list.add(List.of(1));
        list.add(List.of(1));
        list.add(List.of(1, 2));
        list.add(List.of(2, 3));
        System.out.println(winner(4, list));
    }
    public static String winner(int n, List<List<Integer>> lists) {
        boolean[] win = new boolean[n + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j: lists.get(i)) {
                if (i - j >= 0 && !win[i - j]){
                    win[i] = true;
                    break;
                }
            }
        }
        if (win[n]) return "Первый";
        else return "второй";

    }
}