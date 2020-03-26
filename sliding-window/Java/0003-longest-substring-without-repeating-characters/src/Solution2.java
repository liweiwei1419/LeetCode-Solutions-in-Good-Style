import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    // 使用哈希表加快搜索

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int left = 0;
        // 非空的时候，结果至少是 1 ，因此初值可以设置成为 1
        int res = 1;
        //  key 为字符，val 记录了当前读到的字符的索引，在每轮循环的最后更新
        Map<Character, Integer> map = new HashMap<>(len);

        char[] charArray = s.toCharArray();

        for (int right = 0; right < len; right++) {
            // 右边界没有重复的时候，直接向右边扩张就好了
            // 右边界有重复的时候，只要在滑动窗口内，我们就得更新
            // 如果在滑动窗口之外，一定是之前被计算过的
            if (map.containsKey(charArray[right])) {
                if (map.get(charArray[right]) >= left) {
                    // 下一个不重复的子串至少在之前重复的那个位置之后
                    // 【特别注意】快在这个地方，左边界直接跳到之前重复的那个位置之后
                    left = map.get(charArray[right]) + 1;
                }
            }
            // 此时滑动窗口内一定没有重复元素
            res = Math.max(res, right - left + 1);
            // 无论如何都更新位置
            map.put(charArray[right], right);
        }
        return res;
    }

    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        String s = "dvdf";
        Solution2 solution2 = new Solution2();
        int lengthOfLongestSubstring = solution2.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}
