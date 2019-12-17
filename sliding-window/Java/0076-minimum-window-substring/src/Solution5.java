/**
 * @author liweiwei1419
 * @date 2019/10/12 1:33 下午
 */
public class Solution5 {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0) {
            return "";
        }
        int[] pattern = new int[128];
        int[] window = new int[128];
        for (char tChar : t.toCharArray()) {
            pattern[tChar]++;
        }
        int tCount = 0;
        int sCount = 0;
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                tCount++;
            }
        }
        int left = 0;
        int right = 0;
        int minLen = sLen + 1;
        int start = 0;
        while (right < sLen) {
            char rightChar = s.charAt(right);
            if (pattern[rightChar] > 0) {
                window[rightChar]++;
                if (window[rightChar] == pattern[rightChar]) {
                    sCount++;
                }
            }
            right++;
            while (sCount == tCount) {
                char leftChar = s.charAt(left) ;
                if (pattern[leftChar] > 0) {
                    window[leftChar]--;
                    if (window[leftChar] < pattern[leftChar]) {
                        sCount--;
                    }
                }
                // 滑动窗口：[left , right)：长度：right - left
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                left++;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
