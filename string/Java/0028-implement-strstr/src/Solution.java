public class Solution {

    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if (hlen == 0) {
            return -1;
        }
        if (nlen == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "ll";
        int strStr = solution.strStr(haystack, needle);
        System.out.println(strStr);
    }
}
