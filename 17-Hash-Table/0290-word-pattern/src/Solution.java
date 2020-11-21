import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution {

    // 思路非常简单，但是要注意题目中给出的测试用例，不同字母是不可以对应到相同的单词的

    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        int n = pattern.length();
        Character c;
        String word;
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            c = pattern.charAt(i);
            word = split[i];
            if (map.containsKey(c)) {
                if (!(map.get(c).equals(word))) {
                    return false;
                }
            } else {
                if (set.contains(word)) {
                    return false;
                }
                map.put(c, word);
                set.add(word);
            }
        }
        return true;
    }
}