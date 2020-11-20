import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Solution {

    // 这里涉及排序操作，因此不能使用 HashMap，要使用 TreeMap

    public String frequencySort(String s) {

        char[] charArray = s.toCharArray();

        // 第 1 步：统计输入字符串（字符数组）的字符频数
        Map<Character, Integer> freq = new HashMap<>();
        for (Character c : charArray) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 升序排序
        Map<Integer, ArrayList<Character>> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);

        ArrayList<Character> clist;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (treeMap.containsKey(entry.getValue())) {
                treeMap.get(entry.getValue()).add(entry.getKey());
            } else {
                clist = new ArrayList<>();
                clist.add(entry.getKey());
                treeMap.put(entry.getValue(), clist);
            }
        }

        // 调试代码
        // System.out.println(treeMap);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, ArrayList<Character>> entry : treeMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                sb.append(String.valueOf(entry.getValue().get(i)).repeat(Math.max(0, entry.getKey())));
            }
        }
        return sb.toString();
    }
}