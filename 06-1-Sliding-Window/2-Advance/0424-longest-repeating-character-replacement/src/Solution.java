public class Solution {

    public int characterReplacement(String s, int k) {
        int sLen = s.length();
        if (sLen < 2) {
            return 0;
        }

        int left = 0;
        int right = 0;
        // 因为题目中说，只出现大写字母
        int[] freq = new int[26];

        // 在滑动的过程中，出现的字符频数最多的个数
        int maxCount = 0;
        int res = 1;

        char[] charArray = s.toCharArray();
        while (right < sLen) {
            freq[charArray[right] - 'A']++;
            // 注意：在这里更新
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);

            right++;

            // 窗口大小 > 重复字符出现次数 + k ，说明重复字符不能填满整个窗口
            while (right - left > maxCount + k) {
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}