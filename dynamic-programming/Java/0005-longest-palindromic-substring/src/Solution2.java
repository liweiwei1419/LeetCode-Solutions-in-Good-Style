public class Solution2 {

    // 中心扩散法

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(s, i, i);
            // System.out.println("oddLen：" + oddLen);
            int evenLen = expandAroundCenter(s, i, i + 1);
            // System.out.println("evenLen：" + evenLen);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 回文串的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心两个字符，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，
        // 此时回文串的长度是 j - i
        return j - i - 1;
    }
}
