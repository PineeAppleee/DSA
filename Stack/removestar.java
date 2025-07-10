package stack;

import java.util.ArrayList;
import java.util.Stack;

public class removestar {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
    public static String removeStars(String s) {
        Stack<Character> s1 = new Stack<>();
        String sh = "";
        for (int i = 0; i < s.length(); i++) {

            if (!s1.isEmpty() && s.charAt(i) == '*') {
                s1.pop();
            } else {
                s1.push(s.charAt(i));
            }

        }
        if (s.isEmpty()) {
            return sh;
        }
        int i = 0;
        while (s1.isEmpty() == false&&i<s1.size()) {
            sh = sh + s1.get(i);
         i++;
        }
        return sh;
    }
}
