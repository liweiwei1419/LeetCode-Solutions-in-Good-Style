import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/29 9:36 上午
 */
public class Solution6 {

    // 广度优先遍历

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }

        String[] digitsMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 注意：设置 res 的初始值为 ""
        res.add("");

        // 思路：新一轮在上一轮的基础末尾追加数字
        for (int i = 0; i < len; i++) {
            // 得到当前的数字，注意：这个偏移是 '2'
            int num = digits.charAt(i) - '2';
            String strList = digitsMap[num];
            List<String> cur = new ArrayList<>();
            for (String s : res) {
                for (char c : strList.toCharArray()) {
                    cur.add(s + c);
                }
            }
            res = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        List<String> letterCombinations = solution6.letterCombinations("23");
        System.out.println(letterCombinations);
    }
}