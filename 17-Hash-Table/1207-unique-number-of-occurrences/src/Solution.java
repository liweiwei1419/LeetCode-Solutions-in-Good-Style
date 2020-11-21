import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Set<Integer> hashSet = new HashSet<>();
        for (int count : freq.values()) {
            if (hashSet.contains(count)) {
                return false;
            }
            hashSet.add(count);
        }

        return true;
    }
}