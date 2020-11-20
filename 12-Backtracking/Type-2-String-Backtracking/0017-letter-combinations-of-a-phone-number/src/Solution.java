import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 题解地址：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/hui-su-sou-suo-wu-xian-shi-hui-su-yan-du-you-xian-/
    // 方法一：回溯

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }
        String[] digitsMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, digitsMap, 0, "", res);
        return res;
    }

    /**
     * @param digits 原始字符串
     * @param index  当前确定的组合的下标
     * @param path   已经得到的字符串
     */
    private void dfs(String digits, String[] digitsMap, int index, String path, List<String> res) {
        // 先写递归终止条件
        if (index == digits.length()) {
            // 由于字符串的特殊性，path 每次都是新的，因此无需再创建拷贝
            res.add(path);
            return;
        }
        // 注意：这里要减去一个偏移
        String nextStr = digitsMap[digits.charAt(index) - '2'];
        char[] charArray = nextStr.toCharArray();
        for (char c : charArray) {
            // 注意：path + c 生成新的字符串，无需状态重置
            dfs(digits, digitsMap, index + 1, path + c, res);
        }
    }
}