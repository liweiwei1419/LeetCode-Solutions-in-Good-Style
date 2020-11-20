import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

    // 方法一：滑动窗口（用哈希表表示字符频数数组）

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen == 0 || pLen == 0) {
            return res;
        }

        Map<Character, Integer> text = new HashMap<>();
        Map<Character, Integer> pattern = new HashMap<>();

        char[] charArrayP = p.toCharArray();
        for (Character c : charArrayP) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        char[] charArrayS = s.toCharArray();
        while (right < sLen) {
            if (pattern.containsKey(charArrayS[right])) {
                text.put(charArrayS[right], text.getOrDefault(charArrayS[right], 0) + 1);
                if (text.get(charArrayS[right]).equals(pattern.get(charArrayS[right]))) {
                    count++;
                }
            }
            right++;

            while (count == pattern.size()) {
                if (right - left == p.length()) {
                    // 因为 right 超过了 1 位，因此这里不用 + 1
                    res.add(left);
                }

                if (pattern.containsKey(charArrayS[left])) {
                    Integer currentCount = text.get(charArrayS[left]);
                    currentCount--;
                    text.put(charArrayS[left], currentCount);
                    if (currentCount < pattern.get(charArrayS[left])) {
                        count--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}