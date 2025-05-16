import java.util.HashMap;
/*
Задача 1
Напишите функцию, которая принимает на вход текст и вовращает
количество вхождений каждого слова
(с учетом окончаний. Т.е. "яблоко" и "яблока" -- это два разных слова ).
Сложность -- O(n)

 */
public class Task1 {
    public static void main(String[] args) {
        String str = "Hello, World World World";

        count(str);
    }

    public static void count(String line) {
        HashMap<String, Integer> map = new HashMap<>();

        line = line.replace(".", "")
                .replace(",", "")
                .replace("!", "");

        String[] parts = line.split(" ");

        for (String w : parts) {
            if (map.get(w) == null) {
                map.put(w, 1);
            } else {
                int temp = map.get(w);
                map.put(w, temp + 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
