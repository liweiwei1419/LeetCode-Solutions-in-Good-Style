import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    // 讨论区解法

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
}