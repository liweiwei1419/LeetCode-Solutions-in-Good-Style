import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 讨论区的解法，更酷一些
 *
 * @author liwei
 * @date 18/7/1 上午9:40
 */
public class Solution3 {

    public List<String> findRepeatedDnaSequences(String s) {

        int len = s.length();
        List<String> res = new ArrayList<>();

        Set<Integer> seen = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();

        Map<Character, Integer> map = new HashMap<>();

        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int v = 0;

        // Use a sliding window to check every 10-bit substring
        for (int i = 0; i < len; i++) {
            // 2 bits/char * 10 char = 20 bits so use 0xfffff
            v = (v << 2 | map.get(s.charAt(i))) & 0xfffff;
            if (i < 9) {
                continue;
            }
            // Check each 10-bit substring
            // If first come out duplicates, then add to list
            if (!seen.add(v) && repeated.add(v)) {
                res.add(s.substring(i - 9, i + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution3 solution3 = new Solution3();
        List<String> repeatedDnaSequences = solution3.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);
    }
}
