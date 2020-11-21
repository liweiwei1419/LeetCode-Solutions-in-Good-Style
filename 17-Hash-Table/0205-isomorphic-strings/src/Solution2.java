import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < slen; i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if (!map.containsKey(curS)) {
                // 反例 ab
                // aa
                if (set.contains(curT)) {
                    return false;
                } else {
                    map.put(curS, curT);
                    set.add(curT);
                }
            } else {
                // 如果含有这个键
                // 看看值是不是相等
                // 并且还要排除有没有出现过
                if (!map.get(curS).equals(curT)) {
                    return false;
                }
            }
        }
        return true;
    }
}