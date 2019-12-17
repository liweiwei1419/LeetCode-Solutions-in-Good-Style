/**
 * @author liweiwei1419
 * @date 2019/10/11 11:02 下午
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s2Len == 0) {
            return false;
        }

        int[] pattern = new int[128];
        int[] window = new int[128];
        int s1Count = 0;
        int s2Count = 0;
        for (char s1Char : s1.toCharArray()) {
            pattern[s1Char]++;
        }
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                s1Count++;
            }
        }

        int left = 0;
        int right = 0;

        while (right < s2Len) {
            if (pattern[s2.charAt(right)] > 0) {
                window[s2.charAt(right)]++;
                if (window[s2.charAt(right)] == pattern[s2.charAt(right)]) {
                    s2Count++;
                }
            }
            right++;
            // 条件：s2 中包含 s1 中所有的字符
            while (s1Count == s2Count) {
                if (right - left == s1Len) {
                    return true;
                }
                // 左边界尽量向左边收缩
                if (pattern[s2.charAt(left)] > 0) {
                    window[s2.charAt(left)]--;
                    if (window[s2.charAt(left)] < pattern[s2.charAt(left)]) {
                        s2Count--;
                    }
                }
                left++;
            }
        }
        return false;
    }
}
