package ru.itis.aasd403.lab01;


public class SelectSort {
    public static void main(String[] args) {
        int[] arr  = {12, 6, 7, 4, 2, 9, 11, 33, 1};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[indexMin] > arr[j]) {
                    indexMin = j;
                }
            }
            swap(arr, indexMin, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
