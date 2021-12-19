import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) {
            res.add(S);
            return res;
        }
        char[] chars = S.toCharArray();
        dfs(chars, len, 0, res);
        return res;
    }

    private void dfs(char[] chars, int len, int index, List<String> res) {
        // 递归终止的时候
        if (index == len) {
            res.add(new String(chars));
            return;
        }
        // 不变化的时候递归搜索一次
        dfs(chars, len, index + 1, res);

        // 如果是字母，就变化了以后，再递归搜索一次
        if ((chars[index] + "").matches("[a-zA-Z]")) {
            change(chars, index);
            // 变化了以后递归搜索一次
            dfs(chars, len, index + 1, res);
        }
    }

    /**
     * 将 chars 数组中 index 数位上的字符改变大小写
     * 这个 change 可以使用异或运算代替
     *
     * @param chars
     * @param index
     */
    private void change(char[] chars, int index) {
        if (chars[index] >= 97) {
            chars[index] -= 32;
            return;
        }
        if (chars[index] >= 65) {
            chars[index] += 32;
        }
    }
}