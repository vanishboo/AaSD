public class Task2 {
//    Есть строка. Нужно развернуть строку так, чтобы каждое из слов осталось в естественном порядке.
//    Например.
//    Input 1: A = "the sky is blue"
//    Output 1: "blue is sky the"
//    Input 2: A = "this is ib"
//    Output 2: "ib is this".
//    Сложность линейная, с О(1) дополнительной памяти.

    public static void main(String[] args) {
        String a = "the sky is blue";
        String b = "this is ib";
        reverse(a);
        reverse(b);
    }

    public static void reverse(String str) {
        int end = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                for (int j = i + 1; j < end; j++) {
                    System.out.print(str.charAt(j));
                }
                System.out.print(" ");
                end = i;
            } else if (i == 0) {
                for (int j = 0; j < end; j++) {
                    System.out.print(str.charAt(j));
                }
                System.out.println();
            }
        }
    }
}
