import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/9 3:49 下午
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pattern = new int[128];
        int[] window = new int[128];
        for (char pChar : p.toCharArray()) {
            pattern[pChar]++;
        }
        int sCount = 0;
        int pCount = 0;
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        int sLen = s.length();
        int pLen = p.length();
        while (right < sLen) {
            char rightChar = s.charAt(right);
            if (pattern[rightChar] > 0) {
                window[rightChar]++;
                if (pattern[rightChar] == window[rightChar]) {
                    sCount++;
                }
            }
            right++;

            while (pCount == sCount) {
                if (right - left == pLen) {
                    res.add(left);
                }
                char leftChar = s.charAt(left);
                if (pattern[leftChar] > 0) {
                    window[leftChar]--;
                    if (window[leftChar] < pattern[leftChar]) {
                        sCount--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution solution = new Solution();
        List<Integer> res = solution.findAnagrams(s, p);
        System.out.println(res);
    }
}
