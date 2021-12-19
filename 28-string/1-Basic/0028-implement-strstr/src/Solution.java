public class Solution {

    // 滚动哈希

    public int strStr(String haystack, String needle) {
        int base = 2333;
        int p = 1_000_000_007;
        int n = haystack.length();
        int m = needle.length();
        if (n < m) {
            return -1;
        }

        long hashA = 0;
        long hashB = 0;
        long baseTop = 1;

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        for (int i = 0; i < m; i++) {
            hashA = (hashA * base + haystackArr[i] - 'a') % p;
            hashB = (hashB * base + needleArr[i] - 'a') % p;
            if (i > 0) {
                baseTop = baseTop * base % p;
            }
        }
        if (hashA == hashB) {
            return 0;
        }
        for (int i = m; i < n; i++) {
            int top = (int) (baseTop * (haystackArr[i - m] - 'a') % p);
            hashA = ((hashA - top + p) * base + haystackArr[i] - 'a') % p;
            if (hashA == hashB) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "";
        String needle = "a";
        Solution solution = new Solution();
        int res = solution.strStr(haystack, needle);
        System.out.println(res);
    }
}