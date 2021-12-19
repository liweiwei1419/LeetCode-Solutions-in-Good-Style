import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        // 存的是索引
        Stack<Integer> stack = new Stack<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    right.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(stack);
        System.out.println(right);
        right.addAll(stack);

        Collections.sort(right);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {

        }

        return "";
    }
}