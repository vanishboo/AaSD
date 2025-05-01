package ru.itis.aasd403.lab01;

import java.lang.reflect.Array;
import java.util.Scanner;

public class TaskSkobki {
    public static void main(String[] args) {

        System.out.println(check("({)}"));
        System.out.println(check2("{}(())[()]"));
        }

    public static boolean check(String s) {
        MyStack<Character> stack = new MyStack<>();
        for (Character c: s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.pop() != '(' ||
                    c == '}' && stack.pop() != '{' ||
                    c == ']' && stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean check2(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                return s.isEmpty();
        }
        }
    }
}


