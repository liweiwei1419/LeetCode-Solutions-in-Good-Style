/**
 * @author liweiwei1419
 * @date 2019/10/9 1:05 下午
 */
public class Solution4 {
    /**
     * 首先建立文本串和模式串的概念
     *
     * @param s 文本串
     * @param t 模式串
     * @return
     */
    public String minWindow(String s, String t) {
        int[] pattern = new int[128];
        int[] window = new int[128];
        for (char ct : t.toCharArray()) {
            pattern[ct]++;
        }
        // t 中有多少种字符，重复字符只记录一次
        int tCount = 0;
        // 滑动窗口内有多少种字符在 t 中
        int sCount = 0;
        // 首先计算滑动窗口内的元素和 pattern 的差距
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                tCount++;
            }
        }
        int sLen = s.length();
        int start = 0;
        int left = 0;
        int right = 0;
        int minLen = sLen + 1;
        // 右边界可以前进的条件：还没有包含 T 的所有字母
        // 左边界可以前进的条件：已经包含了 T 的所有字母
        while (right < sLen) {
            if (pattern[s.charAt(right)] > 0) {
                window[s.charAt(right)]++;
                if (window[s.charAt(right)] == pattern[s.charAt(right)]) {
                    sCount++;
                }
            }
            right++;
            while (sCount == tCount) {
                // 滑动窗口：[left, right)，其长度：right - left
                // 想清楚为什么在这里取最小值，此时 [left, right) 内正好包含 T 的所有字母
                // 这一段要写在 left 移动之前
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if (pattern[s.charAt(left)] > 0) {
                    window[s.charAt(left)]--;
                    if (window[s.charAt(left)] < pattern[s.charAt(left)]) {
                        sCount--;
                    }
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
