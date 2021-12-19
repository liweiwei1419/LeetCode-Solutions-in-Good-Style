import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution4 {

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        // 10 个字符，1 个字符编码成二进制的 2 位，所以是 20 位
        // 0x 表示十六进制，一个 f 表示 1111
        int mask = 0xfffff;
        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        // 表示二进制 00
        map.put('A', 0);
        // 表示二进制 01
        map.put('C', 1);
        // 表示二进制 10
        map.put('G', 2);
        // 表示二进制 11
        map.put('T', 3);
        int v = 0;
        for (int i = 0; i < len; i++) {
            // 空出两位，用来存放当前遍历到的字符的编码
            v <<= 2;
            // 可以用 + 也可以用 |，& mask 的作用是把上一步左移出了 20 位的那两位抹去
            v = (v | map.get(s.charAt(i))) & mask;
            if (i < 9) {
                continue;
            }
            if (seen.contains(v)) {
                repeated.add(s.substring(i - 9, i + 1));
            } else {
                seen.add(v);
            }
        }
        return new ArrayList<>(repeated);
    }
}