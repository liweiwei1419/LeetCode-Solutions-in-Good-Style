import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 哈希表，最优解

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }

        int res = 1;
        // key：数值，value：最新的下标
        Map<Character, Integer> map = new HashMap<>(len);
        char[] charArray = s.toCharArray();

        int left = 0;
        int right = 0;
        // [left, right) 没有重复元素
        while (right < len) {
            Character c = charArray[right];
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            right++;

            res = Math.max(res, right - left);
        }
        return res;
    }
}