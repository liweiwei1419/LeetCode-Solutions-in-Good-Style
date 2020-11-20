public class Solution2 {

    // 哈希表（直接使用数组实现），最优解

    public int lengthOfLongestSubstring(String s) {
        // 重复元素上一次出现的位置很重要
        int len = s.length();
        if (len < 2) {
            return len;
        }

        // 当做哈希表使用。key：字符的 ASCII 值，value：最新下标
        int[] window = new int[128];
        for (int i = 0; i < 128; i++) {
            window[i] = -1;
        }

        char[] charArray = s.toCharArray();

        int res = 1;
        int left = 0;
        // [left, right) 没有重复元素
        for (int right = 0; right < len; right++) {
            if (window[charArray[right]] != -1) {
                left = Math.max(left, window[charArray[right]] + 1);
            }
            window[charArray[right]] = right;
            // 注意理解这里为什么是 + 1
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}