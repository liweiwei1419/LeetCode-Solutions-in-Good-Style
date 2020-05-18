public class Solution2 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();

        // 边界要特别清楚
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                // 这一步要解释清楚
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param charArray 原始字符串的字符数组
     * @param left      左边界（可以取到）
     * @param right     右边界（可以取到）
     * @return 回文串的长度
     */
    private int expandAroundCenter(char[] charArray, int left, int right) {
        // 当 left = right 的时候，回文中心是一个字符，回文串的长度是奇数
        // 当 right = left + 1 的时候，此时回文中心两个字符，回文串的长度是偶数
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，
        // 此时回文串的长度是 j - i + 1 - 2 = j - i - 1
        return j - i - 1;
    }
}
