public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len == 0 || s2Len == 0 || s1Len > s2Len) {
            return false;
        }

        // ascii('z') = 122
        int[] s1Freq = new int[128];
        int[] winFreq = new int[128];

        char[] charArray1 = s1.toCharArray();
        for (char c : charArray1) {
            s1Freq[c]++;
        }

        // 滑动窗口包含了 s1 的字符的个数（超过部分不计算）
        int distance = 0;
        char[] charArrayS2 = s2.toCharArray();

        int left = 0;
        int right = 0;
        while (right < s2Len) {
            if (s1Freq[charArrayS2[right]] == 0) {
                right++;
                continue;
            }

            if (winFreq[charArrayS2[right]] < s1Freq[charArrayS2[right]]) {
                distance++;
            }

            winFreq[s2.charAt(right)]++;
            right++;


            // 条件：s2 中包含 s1 中所有的字符
            while (distance == s1Len) {
                if (right - left == s1Len) {
                    return true;
                }

                if (s1Freq[charArrayS2[left]] == 0) {
                    left++;
                    continue;
                }

                if (winFreq[charArrayS2[left]] == s1Freq[charArrayS2[left]]) {
                    distance--;
                }
                winFreq[s2.charAt(left)]--;
                left++;
            }
        }
        return false;
    }
}