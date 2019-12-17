public class Solution {

    public String minWindow(String s, String t) {
        int[] window = new int[128];
        int[] pattern = new int[128];

        final int A = 'A';

        for (Character c : t.toCharArray()) {
            pattern[c - A]++;
        }
        int distance = 0;

        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                distance++;
            }
        }

        int sLen = s.length();
        int start = 0;
        int left = 0;
        int right = 0;
        int match = 0;
        int minLen = sLen + 1;

        while (right < sLen) {
            Character curChar = s.charAt(right);
            if (pattern[curChar - A] > 0) {
                window[curChar - A]++;

                if (window[curChar - A] == pattern[curChar - A]) {
                    match++;
                }
            }

            right++;

            while (match == distance) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                // 考虑左边界向右边走
                Character leftChar = s.charAt(left);
                if (pattern[leftChar - A] > 0) {
                    window[leftChar - A]--;

                    if (window[leftChar - A] < pattern[leftChar - A]) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String minWindow = solution.minWindow(S, T);
        System.out.println(minWindow);
    }
}
