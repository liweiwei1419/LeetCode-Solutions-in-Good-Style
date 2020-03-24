public class Solution {

    // 特殊测试用例： A="abc", B="cab"
    // A   "abcd"，
    //     "abcdabcd"
    //   B = "cdabcdab"。
    public int repeatedStringMatch(String A, String B) {
        int blen = B.length();
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder(A);
        while (stringBuilder.length() < blen) {
            stringBuilder.append(A);
            count++;
        }
        if (stringBuilder.indexOf(B) >= 0) {
            return count;
        }
        stringBuilder.append(A);
        if (stringBuilder.indexOf(B) >= 0) {
            return count + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        Solution solution = new Solution();
        int repeatedStringMatch = solution.repeatedStringMatch(A, B);
        System.out.println(repeatedStringMatch);
    }
}
