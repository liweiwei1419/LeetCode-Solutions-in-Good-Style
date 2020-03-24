import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/isomorphic-strings/description/

// 重点：建立映射关系的时候，要检查是不是两个 key 对应到同一个 value 上了

// https://leetcode-cn.com/problems/isomorphic-strings/description/
// 越是简单的问题，越有小陷阱
// 测试用例：输入："ab"、"aa"
// 输出：false

public class Solution {

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

    public boolean isIsomorphic1(String s, String t) {
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
                if (curT != map.get(curS)) {
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


    // 两个字符不能映射到同一个字符上，但字符可以映射自己本身
    // 正例：ab cd
    // 反例：ab cc
    public boolean isIsomorphic2(String s, String t) {
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
            } else {// 如果当前遍历的字符以前出现过，检查取出的 value 是否匹配
                if (map.get(curS) != curT) {
                    return false;
                }
            }
        }
        return true;
    }

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

    public static void main(String[] args) {
        // String s = "egg";String t = "add";
        // String s = "foo";String t = "bar";
        // String s = "paper";String t = "title";
        String s = "ab";
        String t = "aa";
        boolean isomorphic = new Solution().isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

}
