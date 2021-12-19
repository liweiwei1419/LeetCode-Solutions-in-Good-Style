import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution5 {

    // 两个字符不能映射到同一个字符上，但字符可以映射自己本身
    // 正例：ab cd
    // 反例：ab cc

    public boolean isIsomorphic3(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Character curS = s.charAt(i);
            Character curT = t.charAt(i);
            if (!map.containsKey(curS)) {
                map.put(curS, curT);
                if (!set.contains(curT)) {
                    set.add(curT);
                } else {
                    return false;
                }
            } else {
                // 如果当前遍历的字符以前出现过，检查取出的 value 是否匹配
                if (!map.get(curS).equals(curT)) {
                    return false;
                }
            }
        }
        return true;
    }
}