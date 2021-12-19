import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] ps = paragraph.toLowerCase().split("[^a-z]");
        // 注意会有空的字符串出现
        // System.out.println(Arrays.toString(ps));
        for (String p : ps) {
            if ("".equals(p)) {
                continue;
            }
            if (!set.contains(p)) {
                if (map.containsKey(p)) {
                    map.put(p, map.get(p) + 1);
                } else {
                    map.put(p, 1);
                }
            }
        }
        int max = 0;
        String mcw = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mcw = entry.getKey();
            }
        }
        return mcw;
    }
}