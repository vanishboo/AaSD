package ru.itis.aads;

public class Karatsuba_HW {

    public static void main(String[] args) {
        String x = "1101";
        String y = "1000";

        String result = multiply(x, y);
        System.out.println(inInt(result));
    }

    public static String multiply(String x, String y) {
        int length = Math.max(x.length(), y.length());

        x = addZeros(x, length);
        y = addZeros(y, length);

        if (length == 1) {
            return multiplyOneBit(x, y);
        }

        int mid = length / 2;

        String a = x.substring(0, mid);
        String b = x.substring(mid);
        String c = y.substring(0, mid);
        String d = y.substring(mid);

        String p1 = multiply(a, c);
        String p2 = multiply(b, d);
        String p3 = multiply(addBinary(a, b), addBinary(c, d));

        String middle = subtractBinary(subtractBinary(p3, p1), p2);

        String part1 = p1 + zeros(2 * (length - mid));
        String part2 = middle + zeros(length - mid);

        return addBinary(addBinary(part1, part2), p2);
    }

    public static String addZeros(String s, int length) {
        while (s.length() < length) {
            s = "0" + s;
        }
        return s;
    }

    public static String multiplyOneBit(String a, String b) {
        return (a.equals("1") && b.equals("1")) ? "1" : "0";
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static String subtractBinary(String a, String b) {
        a = addZeros(a, Math.max(a.length(), b.length()));
        b = addZeros(b, Math.max(a.length(), b.length()));

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            int diff = (a.charAt(i) - '0') - (b.charAt(i) - '0') - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
        }

        return result.reverse().toString().replaceFirst("^0+(?!$)", "");
    }

    public static String zeros(int count) {
        return "0".repeat(count);
    }

    public static int inInt(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
