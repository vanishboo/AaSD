import java.util.*;
//Задача 3
//Даны два массива целых чисел. Вернуть массив их общих элементов, где количесвто вхождений каждого элемента равно минимальному из его встречаемости в обоих массивах
//Пример:
//        [2, 4, 4, 1], [2, 2, 4, 5]
//Вывод:
//        [2, 4]
public class Task3 {
    public static void main(String[] args) {
        int[] firstArray = {2, 4, 4, 1, 5};
        int[] secondArray = {2, 2, 4, 5, 1};

        int[] result = common(firstArray, secondArray);
        System.out.println(Arrays.toString(result));
    }

    public static int[] common(int[] firstArray, int[] secondArray) {
        List<Integer> resultList = new ArrayList<>();


        Map<Integer, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < firstArray.length; i++) {
            int value = firstArray[i];
            firstMap.put(value, firstMap.getOrDefault(value, 0) + 1);
        }


        Map<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < secondArray.length; i++) {
            int value = secondArray[i];
            secondMap.put(value, secondMap.getOrDefault(value, 0) + 1);
        }


        for (int number : firstMap.keySet()) {
            if (secondMap.containsKey(number)) {

                int cnt1 = firstMap.get(number);
                int cnt2 = secondMap.get(number);
                int min = Math.min(cnt1, cnt2);

                for (int i = 0; i < min; i++) {
                    resultList.add(number);
                }
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}
