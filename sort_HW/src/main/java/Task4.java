import java.util.Arrays;

public class Task4 {
//    Задача 4
//    Дан список неотрицательных чисел и некоторое число s.
//    Необходимо вывести максимальное количество чисел из списка, сумма которых не превышает s.
//    Пример:
//    [15, 5, 11, 10, 12], s = 30,
//    тогда ответ будет 3
//    (например, 5 + 10 + 11 < 30)
    public static void main(String[] args) {
        int[] arr = {15, 5, 11, 10, 12};
        System.out.println(maxCnt(arr, 30));
    }

    public static int maxCnt(int[] arr, int s) {
        Arrays.sort(arr);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum <= s) res++;
            else break;
        }
        return res;
    }
}
