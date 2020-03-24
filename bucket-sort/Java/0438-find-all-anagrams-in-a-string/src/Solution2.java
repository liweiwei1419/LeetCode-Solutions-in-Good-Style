import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/9 4:18 下午
 */
public class Solution2 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        if (sLen == 0) {
            return res;
        }
        int sCount = 0;
        int pCount = 0;
        int[] pattern = new int[128];
        for (char pChar : p.toCharArray()) {
            pattern[pChar]++;
        }
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                pCount++;
            }
        }
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int pLen = p.length();
        while (right < sLen) {
            if (pattern[s.charAt(right)] > 0) {
                window[s.charAt(right)]++;
                if (window[s.charAt(right)] == pattern[s.charAt(right)]) {
                    sCount++;
                }
            }
            right++;
            while (pCount == sCount) {
                if (right - left == pLen) {
                    res.add(left);
                }
                if (pattern[s.charAt(left)] > 0) {
                    window[s.charAt(left)]--;
                    if (window[s.charAt(left)] < pattern[s.charAt(left)]) {
                        sCount--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
