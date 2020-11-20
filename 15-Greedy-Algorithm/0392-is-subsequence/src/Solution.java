public class Solution {

    // 贪心算法

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;

    }
}