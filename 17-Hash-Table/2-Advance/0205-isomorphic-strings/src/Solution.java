import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // 重点：建立映射关系的时候，要检查是不是两个 key 对应到同一个 value 上了
    // 越是简单的问题，越有小陷阱
    // 测试用例：输入："ab"、"aa"
    // 输出：false

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        Character curS;
        Character curT;
        for (int i = 0; i < n; i++) {
            curS = s.charAt(i);
            curT = t.charAt(i);
            if (map.containsKey(curS)) {
                if (!curT.equals(map.get(curS))) {
                    return false;
                }
            } else {
                if (set.contains(curT)) {
                    return false;
                } else {
                    set.add(curT);
                    map.put(curS, curT);
                }
            }
        }
        return true;
    }
}