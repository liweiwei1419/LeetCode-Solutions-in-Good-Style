public class Solution4 {

    // 同 Solution3，注释比较多

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        // 当 window 中某个字符的频数为 2 时，表示滑动窗口内有重复字符
        int[] cnt = new int[128];
        // 右边界滑动到刚刚好有重复的时候停下
        // 左边界滑动到刚刚好没有重复的时候停下
        int left = 0;
        int right = 0;
        // 滑动窗口内是否重复
        boolean repeating = false;
        int res = 1;
        // 循环不变式，保持不变的性质是：[left, right) 内没有重复元素
        while (right < len) {
            // 不能写在后面，因为数组下标容易越界
            if (cnt[s.charAt(right)] == 1) {
                repeating = true;
            }
            cnt[s.charAt(right)]++;
            right++;

            // 此时 [left, right) 内如果没有重复元素，就尝试扩张 right
            // 否则缩小左边界，while 循环体内不断缩小边界
            while (repeating) {
                if (cnt[s.charAt(left)] == 2) {
                    // 如果满足滑动窗口内有重复的元素，尝试不断删除左边元素
                    repeating = false;
                }
                // 只有有重复元素，就得缩短左边界
                cnt[s.charAt(left)]--;
                left++;
            }
            // 此时 [left, right) 内没有重复元素
            res = Math.max(res, right - left);
        }
        return res;
    }
}