import java.util.ArrayList;
import java.util.List;


public class Solution2 {

    private static final int MASK = 1 << 5;

    private void helper(char[] chars, int len, int begin, List<String> res) {
        if (begin == len) {
            res.add(new String(chars));
            return;
        }
        helper(chars, len, begin + 1, res);
        if (Character.isLetter(chars[begin])) {
            chars[begin] ^= MASK;
            helper(chars, len, begin + 1, res);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) {
            res.add(S);
            return res;
        }
        char[] chars = S.toCharArray();
        helper(chars, len, 0, res);
        return res;
    }
}
