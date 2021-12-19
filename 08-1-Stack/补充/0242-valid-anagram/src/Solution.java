import java.util.HashMap;
import java.util.Map;


public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        // 遍历 s 的时候，做加法
        for (Character c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        // 遍历 t 的时候，做减法
        for (Character c : t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) >= 1) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}