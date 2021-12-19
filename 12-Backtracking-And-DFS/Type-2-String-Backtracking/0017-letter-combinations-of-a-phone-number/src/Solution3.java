import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    // 方法二：广度优先遍历

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }

        String[] digitsMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // res 是一个队列
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