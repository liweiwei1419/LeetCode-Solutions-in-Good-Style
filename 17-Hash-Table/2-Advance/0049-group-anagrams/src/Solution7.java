import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution7 {

    // 我们就是想制造哈希冲突，反其道而行
    // 参考资料：https://leetcode.com/problems/group-anagrams/discuss/19233/O(M-*-N)-algorithm-using-hash-without-sort()

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String w : strs){
            String key = hash(w);
            if(!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(w);
        }

        return new ArrayList<>(map.values());
    }

    String hash(String s){
        int[] a = new int[26];
        for(char c : s.toCharArray()) a[c-'a']++;
        return Arrays.toString(a);
    }
}
