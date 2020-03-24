public class Solution2 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param s     原始字符串
     * @param left  左边界（可以取到）
     * @param right 右边界（可以取到）
     * @return 回文串的长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        // 当 left = right 的时候，回文中心是一个字符，回文串的长度是奇数
        // 当 right = left + 1 的时候，此时回文中心两个字符，回文串的长度是偶数
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
        // 跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，此时回文串的长度是 j - i - 1
        return j - i - 1;
    }
}
