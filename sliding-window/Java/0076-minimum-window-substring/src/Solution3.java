import java.util.HashMap;
import java.util.Map;

/**
 * @author liwei
 * @date 2019/8/22 8:36 PM
 */
public class Solution3 {
    public String minWindow(String s, String t) {

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int sLen = s.length();
        int minLen = sLen + 1;
        int start = 0;

        int left = 0;
        int right = 0;
        int match = 0;

        while (right < sLen) {
            Character curChar = s.charAt(right);
            if (need.containsKey(curChar)) {
                window.put(curChar, window.getOrDefault(curChar, 0) + 1);
                if (window.get(curChar).equals(need.get(curChar))) {
                    match++;
                }
            }

            right++;

            while (match == need.size()) {
                if (right - left < minLen) {
                    // 这里不用 + 1
                    start = left;
                    minLen = right - left;
                }

                Character leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    int count = window.get(leftChar);
                    count--;
                    window.put(leftChar, count);
                    if (count < need.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }
}
