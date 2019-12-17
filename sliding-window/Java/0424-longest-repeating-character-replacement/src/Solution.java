/**
 * @author liweiwei1419
 * @date 2019/10/11 7:03 下午
 */
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
        int maxCount = 0;
        int res = 1;
        while (right < sLen) {
            int rCharIndex = s.charAt(right) - 'A';
            cnt[rCharIndex]++;
            // 注意：在这里更新
            maxCount = Math.max(maxCount, cnt[rCharIndex]);
            right++;
            while (right - left > maxCount + k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
