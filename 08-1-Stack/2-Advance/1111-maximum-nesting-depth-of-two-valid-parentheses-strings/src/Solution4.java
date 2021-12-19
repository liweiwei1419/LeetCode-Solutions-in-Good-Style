public class Solution4 {

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] res = new int[len];

        // 嵌套深度，栈的当前高度
        int depth = 0;

        // 在 Java 里，seq.charAt(i) 函数会做下标越界检查，
        // 因此先转换成字符数组是常见的做法
        char[] charArray = seq.toCharArray();

        for (int i = 0; i < len; i++) {
            // 遍历到左括号，连续括号个数加 1，
            if (charArray[i] == '(') {
                depth++;
                // %2 也可以写成 & 1，为了保证语义清楚，写 %2
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