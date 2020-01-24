import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }

    private String[] digitsMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    /**
     * @param digits 原始的输入参数："数字"字符串
     * @param index  当前遍历到的数字字符串的索引，从这个索引到映射表上查找对应的字符数组（例如：字符串 abc）
     * @param pre    已经形成的字符串
     */
    private void dfs(String digits, int index, String pre) {
        // 千万不要忽略了递归终止条件
        if (index == digits.length()) {
            res.add(pre);
            return;
        }
        String currStr = digitsMap[digits.charAt(index) - '0'];
        for (int i = 0; i < currStr.length(); i++) {
            dfs(digits, index + 1, pre + currStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution3 solution3 = new Solution3();
        List<String> letters = solution3.letterCombinations(digits);
        for (String s : letters) {
            System.out.println(s);
        }
    }
}
