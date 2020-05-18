public class Solution {

    public int characterReplacement(String s, int k) {
        int sLen = s.length();
        if (sLen < 2) {
            return 0;
        }

        int left = 0;
        int right = 0;
        // 因为题目中说，只出现大写字母
        int[] cnt = new int[26];

        // 区间里的最大词频数量
        int maxCount = 0;
        int res = 1;

        char[] charArray = s.toCharArray();
        while (right < sLen) {

            cnt[charArray[right] - 'A']++;
            // 注意：在这里更新
            maxCount = Math.max(maxCount, cnt[charArray[right] - 'A']);

            right++;
            while (right - left > maxCount + k) {
                cnt[charArray[left] - 'A']--;
                left++;
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
