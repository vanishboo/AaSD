public class Task1 {

//    Дана последовательность различных чисел, в которой все числа
//    до определенного индекса j отсортированы по убыванию,
//    а после j по возрастанию. Найдите этот индекс j.  (Сложность O(log n).)

    public static void main(String[] args) {
        int[] a = {31, 22, 3};
        System.out.println(checkJ(a));

    }

    public static int checkJ(int[] arr) {

        int l = 1;
        int r = arr.length - 2;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (arr[0] < arr[1]) return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 1;

        return -1;
    }
}
