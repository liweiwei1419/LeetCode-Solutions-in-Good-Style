import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> letterCasePermutation(String S) {
        int len = S.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        char[] charArray = new char[len];
        dfs(S, 0, len, charArray, res);
        return res;
    }

    private void dfs(String S, int begin, int len, char[] charArray, List<String> res) {
        if (begin == len) {
            res.add(new String(charArray));
            return;
        }
        charArray[begin] = S.charAt(begin);
        dfs(S, begin + 1, len, charArray, res);

        // 如果是字符，就可以派生出一个新分支
        if (Character.isLetter(S.charAt(begin))) {
            charArray[begin] = (char) (S.charAt(begin) ^ (1 << 5));
            dfs(S, begin + 1, len, charArray, res);
        }
    }
}