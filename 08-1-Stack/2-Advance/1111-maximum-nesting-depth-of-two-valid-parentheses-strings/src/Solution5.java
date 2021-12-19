public class Solution5 {

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];
        int depth = 0;

        char[] charArray = seq.toCharArray();
        for (int i = 0; i < len; i++) {
            // 遍历到左括号，连续括号个数加 1，
            if (charArray[i] == '(') {
                depth++;
                res[i] = depth % 2;
            } else {
                // 遍历到右括号，与当前栈顶左括号分在一组，因此先取模，再 --
                // 这一步希望大家多体会，很有意思
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;
    }
}