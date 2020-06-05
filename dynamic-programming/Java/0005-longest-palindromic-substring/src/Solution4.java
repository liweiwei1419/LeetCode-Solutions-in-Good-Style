public class Solution4 {

    // Manacher

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        String str = addDividers(s, '#');
        int sLen = 2 * len + 1;

        // p[i]：以预处理字符串下标 i 为中心的回文半径（奇数长度时不包括中心）
        // p 是 palindromic 的首字符
        int[] p = new int[sLen];

        // 通过中心扩散的方式能够扩散的最右边的下标
        int maxRight = 0;
        // 与 maxRight 对应的中心字符的下标
        int center = 0;

        int maxLen = 1;
        int begin = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < sLen; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 状态转移方程，要结合图形来理解
                p[i] = Math.min(maxRight - i, p[mirror]);
            }

            // 尝试使用中心扩散法，更新 p[i] 的值
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);
            while (left >= 0 && right < sLen && charArray[left] == charArray[right]) {
                p[i]++;
                left--;
                right++;
            }

            // 更新 maxRight，它是遍历过的 i 的 i + p[i] 的最大者
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需同时更新
                maxRight = i + p[i];
                center = i;
            }

            // 记录最长回文子串的长度和相应它在原始字符串中的起点
            if (p[i] > maxLen) {
                maxLen = p[i];
                begin = (i - maxLen) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 创建预处理字符串
     *
     * @param s      原始字符串
     * @param divider 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String addDividers(String s, char divider) {
        if (s.indexOf(divider) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }

        char[] charArray = s.toCharArray();
        int len = s.length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divider);
            stringBuilder.append(charArray[i]);
        }
        stringBuilder.append(divider);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String s = "babad";
        String longestPalindrome = solution4.longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
}
