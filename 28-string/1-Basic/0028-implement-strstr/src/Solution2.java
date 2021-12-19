public class Solution2 {

    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if (nlen == 0) {
            return 0;
        }
        for (int i = 0; i <= hlen - nlen; i++) {
            if (needle.equals(haystack.substring(i, i + nlen))) {
                return i;
            }
        }
        return -1;
    }
}