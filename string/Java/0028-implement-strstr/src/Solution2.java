/**
 * @author liwei
 * @date 18/6/28 下午1:33
 */
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

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String haystack = "a";
        String needle = "a";
        int strStr = solution2.strStr(haystack, needle);
        System.out.println(strStr);
    }
}
