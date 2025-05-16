import java.util.HashMap;


//Задача 2
//Дан массив целых чисел и число k. Определить, есть ли в массиве такие два различных индекса i и j, что nums[i] == nums[j] и |i - j| <= k
//Пример:
//        [1, 2, 3, 1, 5], k = 3
//Вывод: true (индекс 0 и 3, расстояние 3)


public class Task2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        int k = 3;

        System.out.println(check(arr, k));
    }

    public static boolean check(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if (map.containsKey(value)) {
                int index = map.get(value);
                if (i - index <= k) {
                    return true;
                }
            }

            map.put(value, i);
        }

        return false;
    }
}
