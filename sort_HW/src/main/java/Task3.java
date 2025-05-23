import java.util.Arrays;

public class Task3 {
//    Дан список неотрицательных чисел.
//    Измените их порядок так, чтобы если их после этого выписать в строку,
//    то получилось максимальное из возможных чисел.
//    Пример: дан массив [3, 30, 34, 5, 9].
//    Максимальное возможное число можно получить 9534330.
//    Сложность O(n log n)
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        return result.toString();
    }


}
