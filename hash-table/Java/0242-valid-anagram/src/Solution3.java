import java.util.HashMap;
import java.util.Map;

// 思路和 1 基本一致

public class Solution3 {

    public boolean isAnagram(String s, String t) {
        boolean isAnagram = true;
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] tArray = t.toCharArray();
        for (char c : tArray) {
            // map.get(c) >= 1 这个条件很重要
            if (map.containsKey(c) && map.get(c) >= 1) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}



