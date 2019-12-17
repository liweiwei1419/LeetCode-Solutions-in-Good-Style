/**
 * @author liweiwei1419
 * @date 2019/10/11 5:06 下午
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int[] window = new int[128];
        int res = 1;
        boolean repeating = false;
        while (right < len) {
            window[s.charAt(right)]++;
            if (window[s.charAt(right)] == 2) {
                repeating = true;
            }
            right++;
            while (repeating) {
                window[s.charAt(left)]--;
                if (window[s.charAt(left)] == 1) {
                    repeating = false;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
