import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean backspaceCompare(String S, String T) {
        return simplify(S).equals(simplify(T));
    }

    private String simplify(String str){
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c != '#') {
                stack.addLast(c);
            } else if (!stack.isEmpty()) {
                stack.pollLast();
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";

//        String S = "ab##";
//        String T = "c#d#";

//        String S = "a##c";
//        String T = "#a#c";

//        String S = "a#c";
//        String T = "b";

        Solution solution = new Solution();
        boolean res = solution.backspaceCompare(S, T);
        System.out.println(res);
    }
}
