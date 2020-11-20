public class Solution3 {

    // 最基本的滑动窗口写法

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        // 描述 [left, right) 里是否有元素的变量
        int[] freq = new int[128];
        // [left, right) 无重复的元素
        int res = 1;
        for (int left = 0, right = 0; right < len; right++) {
            freq[charArray[right]]++;

            if (freq[charArray[right]] == 2) {
                while (freq[charArray[right]] == 2) {
                    freq[charArray[left]]--;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}