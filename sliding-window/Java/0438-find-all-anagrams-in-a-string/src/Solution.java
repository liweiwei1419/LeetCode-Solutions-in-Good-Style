import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        final int A = 'a';
        // 因为字符串只包含小写英文字母
        int[] window = new int[26];
        int[] pattern = new int[26];

        for (Character c : p.toCharArray()) {
            pattern[c - A]++;
        }

        int distance = 0;
        for (int i = 0; i < 26; i++) {
            if (pattern[i] > 0) {
                distance++;
            }
        }

        int sLen = s.length();
        int pLen = p.length();

        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int match = 0;

        while (right < sLen) {
            Character curChar = s.charAt(right);
            if (pattern[curChar - A] > 0) {
                window[curChar - A]++;
                if (window[curChar - A] == pattern[curChar - A]) {
                    match++;
                }
            }
            right++;
            while (match == distance) {
                if (right - left == pLen) {
                    res.add(left);
                }
                // 代码与上面对称
                Character leftChar = s.charAt(left);
                if (pattern[leftChar - A] > 0) {
                    window[leftChar - A]--;
                    if (window[leftChar - A] < pattern[leftChar - A]) {
                        match--;
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
