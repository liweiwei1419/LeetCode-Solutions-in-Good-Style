public class Solution3 {

    // 调用 API

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
}
