public class Solution {

    // 递归 + 分类讨论
    // 使用递归的思想，第 1 个匹配了，后面的递归处理就可以了

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            // '*' 匹配 0 次
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            // '*' 至少匹配 1 次
            return firstMatch && isMatch(s.substring(1), p);
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

}
