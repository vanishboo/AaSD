package ru.itis.aads;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 3};
        System.out.println(Arrays.toString(sum(arr, 4)));
    }
    public static int[] sum(int[] arr, int s) {
        Arrays.sort(arr);
        int n = arr.length;
        int resSum = arr[0] + arr[1] + arr[2];
        int[] res = new int[]{arr[0], arr[1], arr[2]};
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (Math.abs(currentSum - s) < Math.abs(resSum - s)) {
                    resSum = currentSum;
                    res = new int[]{arr[i], arr[left], arr[right]};
                }
                if (currentSum < s) {
                    left++;
                } else if (currentSum > s) {
                    right--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}