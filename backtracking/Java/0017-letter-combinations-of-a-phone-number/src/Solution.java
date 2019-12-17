import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }
        String[] digitsMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findCombinations(digits, digitsMap, 0, "", res);
        return res;
    }

    /**
     * @param digits 原始字符串
     * @param start  从原始字符串的第几位开始搜索
     * @param pre    已经得到的子串
     */
    private void findCombinations(String digits, String[] digitsMap, int start, String pre, List<String> res) {
        // 先写递归终止条件
        if (start == digits.length()) {
            // 由于字符串的特殊性，pre 每次都是新的，因此无需再创建拷贝
            res.add(pre);
            return;
        }
        // 注意：这里要减去一个偏移
        String nextStr = digitsMap[digits.charAt(start) - '2'];
        // 下一个数字所代表的的字母的长度
        int len = nextStr.length();
        for (int i = 0; i < len; i++) {
            // 注意：这里没有状态重置
            findCombinations(digits, digitsMap, start + 1, pre + nextStr.charAt(i), res);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> letterCombinations = solution.letterCombinations("23");
        System.out.println(letterCombinations);
    }
}
