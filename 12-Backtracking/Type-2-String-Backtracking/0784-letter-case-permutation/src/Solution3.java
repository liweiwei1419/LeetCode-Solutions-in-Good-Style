import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) {
            return res;
        }
        char[] chars = S.toCharArray();
        dfs(0, len, chars, res);
        return res;
    }

    private void dfs(int index, int len, char[] chars, List<String> res) {
        if (index == len) {
            res.add(new String(chars));
            return;
        }
        dfs(index + 1, len, chars, res);
        if (Character.isLetter(chars[index])) {
            chars[index] ^= (1 << 5);
            dfs(index + 1, len, chars, res);
        }
    }
}