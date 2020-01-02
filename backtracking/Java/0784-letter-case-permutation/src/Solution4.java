import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        // 特判
        int len = S.length();
        if (len == 0) {
            return res;
        }
        Stack<Character> path = new Stack<>();
        dfs(S, 0, len, path, res);
        return res;
    }

    private void dfs(String S, int index, int len, Stack<Character> stack, List<String> res) {
        if (index == len) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                stringBuilder.append(stack.get(i));
            }
            res.add(stringBuilder.toString());
            return;
        }

        stack.add(S.charAt(index));
        dfs(S, index + 1, len, stack, res);
        stack.pop();

        if (Character.isLetter(S.charAt(index))) {
            stack.add((char) (S.charAt(index) ^ (1 << 5)));
            dfs(S, index + 1, len, stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String S = "a1b2";
        List<String> letterCasePermutation = solution4.letterCasePermutation(S);
        System.out.println(letterCasePermutation);
    }
}

