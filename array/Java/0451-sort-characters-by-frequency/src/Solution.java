import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
// 这里涉及排序操作，因此不能使用 HashMap，要使用 TreeMap

public class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        // 调试代码
        // System.out.println(map);

        Map<Integer, ArrayList<Character>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ArrayList<Character> clist;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
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
                for (int j = 0; j < entry.getKey(); j++) {
                    sb.append(entry.getValue().get(i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        String frequencySort = new Solution().frequencySort(s);
        System.out.println(frequencySort);
    }
}
