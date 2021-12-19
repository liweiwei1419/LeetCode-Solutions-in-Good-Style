import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution3.groupAnagrams(strs);
        System.out.println(res);
    }
}
