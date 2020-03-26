import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }

        int res = 1;
        Map<Character, Integer> map = new HashMap<>(len);
        char[] charArray = s.toCharArray();

        int left = 0;
        for (int right = 0; right < len; right++) {
            Character c = charArray[right];
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            res = Math.max(res, right - left + 1);
            map.put(c, right);
        }
        return res;
    }
}