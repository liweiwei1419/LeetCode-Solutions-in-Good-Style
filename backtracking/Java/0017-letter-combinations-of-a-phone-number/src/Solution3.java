import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return result;
        }
        findCombination(digits, 0, "");
        return result;
    }

    private String[] digitMap = {
            " ",// 0
            "",// 1
            "abc",// 2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9
    };

    /**
     * @param digits 原始的输入参数："数字"字符串
     * @param index  当前遍历到的数字字符串的索引，从这个索引到映射表上查找对应的字符数组（例如：字符串 abc）
     * @param pre    已经形成的字符串
     */
    private void findCombination(String digits, int index, String pre) {
        // 千万不要忽略了递归终止条件
        if (index == digits.length()) {
            result.add(pre);
            return;
        }
        String currStr = digitMap[digits.charAt(index) - '0'];
        for (int i = 0; i < currStr.length(); i++) {
            findCombination(digits, index + 1, pre + currStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution solution = new Solution();
        List<String> letters = solution.letterCombinations(digits);
        for (String s : letters) {
            System.out.println(s);
        }
    }
}
