import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/12 2:45 下午
 */
public class Solution3 {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        List<Integer> res = new ArrayList<>();
        if (sLen == 0) {
            return res;
        }
        int pLen = p.length();

        int[] window = new int[128];
        int[] pattern = new int[128];

        // 如果 s 中某个字符的频率与 p 中一样，sCount 加 1
        int sCount = 0;
        // pCount：p 中不同字符的个数
        int pCount = 0;
        for (char pChar : p.toCharArray()) {
            pattern[pChar]++;
        }
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        while (right < sLen) {
            if (pattern[s.charAt(right)] > 0) {
                window[s.charAt(right)]++;
                if (pattern[s.charAt(right)] == window[s.charAt(right)]) {
                    sCount++;
                }
            }
            right++;

            while (pCount == sCount) {
                // 此时滑动窗口是 [left, right)，长度是 right - left
                if (right - left == pLen){
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
