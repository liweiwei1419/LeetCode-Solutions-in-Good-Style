public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len < 2) {
            return false;
        }
        for (int i = 1; i <= len / 2; i++) {
            // 只有字符串长度整除重复单元的长度的时候，才有必要继续做判断
            if (len % i == 0) {
                // 第 1 个重复单元的字符串
                String template = s.substring(0, i);
                // 每一轮内层循环都假设能找到，只要有一个不匹配，这个值就会被置为 false，然后退出内层循环
                boolean found = true;
                // 注意：substring 的第 2 个参数是右边端点，取不到
                for (int j = i; j + i <= len; j += i) {
                    String segment = s.substring(j, j + i);
                    if (!template.equals(segment)) {
                        found = false;
                        break;
                    }
                }
                // 遍历完整个字符串，都没有将 found 改为 false，就说明，该字符串符合题意，存在性成立，可以直接返回
                if (found) {
                    return true;
                }
            }
        }
        // 存在性问题，如果全部都判断完毕都不能返回 true，就得返回 false
        return false;
    }

    public static void main(String[] args) {
        String s = "aabaaba";
        Solution solution = new Solution();
        boolean repeatedSubstringPattern = solution.repeatedSubstringPattern(s);
        System.out.println(repeatedSubstringPattern);
    }
}
