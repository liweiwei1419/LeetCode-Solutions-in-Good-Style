import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    // 方法一：滑动窗口（用减法）

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen == 0 || pLen == 0 || sLen < pLen) {
            return res;
        }

        char[] charArrayP = p.toCharArray();
        int[] pFreq = new int[26];
        for (char c : charArrayP) {
            pFreq[c - 'a']++;
        }

        int distance = pLen;
        int left = 0;
        int right = 0;
        char[] charArrayS = s.toCharArray();
        // s[left..right) 包含了 p 中所有的字符
        while (right < sLen) {
            if (pFreq[charArrayS[right] - 'a'] > 0) {
                distance--;
            }

            // 特别注意：对于不在 p 中的字符，频数减 1 不影响正确性
            pFreq[charArrayS[right] - 'a']--;
            right++;

            while (distance == 0) {
                if (right - left == pLen) {
                    res.add(left);
                }

                if (pFreq[charArrayS[left] - 'a'] >= 0) {
                    distance++;
                }
                pFreq[charArrayS[left] - 'a']++;
                left++;
            }
        }
        return res;
    }
}