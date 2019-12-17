import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/26 9:29 上午
 */
public class Solution5 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }

        String[] digitsMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // res 就是一个队列
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            int size = res.size();

            String nextStr = digitsMap[digits.charAt(i) - '0'];
            int nextStrLen = nextStr.length();

            for (int j = 0; j < size; j++) {
                String tmp = res.remove(0);
                for (int k = 0; k < nextStrLen; k++) {
                    res.add(tmp + nextStr.charAt(k));
                }
            }
        }
        return res;
    }
}
