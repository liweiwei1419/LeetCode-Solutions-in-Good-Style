import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution6 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String eachString : strs) {
            // only lower-case letters. so array of size 26 is enough
            int[] counter = new int[26];

            // Iterate the string and increment corresponding index
            // char - 'a' , so the index will be between 0 and 25
            for (int j = 0; j < eachString.length(); j++) {
                counter[eachString.charAt(j) - 'a']++;
            }

            // Now iterate thorugh the counter array and construct the hash
            // Eg: cat becomes 1a1c1t. caabbt becomes 2a2b1c1t
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < 26; j++) {
                if (counter[j] > 0) {
                    sb.append(counter[j]);
                    sb.append((char) ('a' + j));
                }
            }

            String hash = sb.toString();

            // Chech if an entry exists in hash table already, else add a new one
            if (!hm.containsKey(hash)) {
                hm.put(hash, new LinkedList<String>());
            }

            //Add this string to the list pointed by hash
            hm.get(hash).add(eachString);
        }

        return new LinkedList<List<String>>(hm.values());
    }
}
