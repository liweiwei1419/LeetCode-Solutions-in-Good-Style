import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private Map<Integer, Integer> freq;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        freq = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        // 向数据结构添加一个数 number
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // 这里需要考虑两种特殊情况：a + a = value 和 a + b = value
        for (Integer num : freq.keySet()) {
            int rest = value - num;
            // 情况 1：a + a = value 的时候，频数要严格大于 1
            if (rest == num && freq.get(rest) > 1) {
                return true;
            }
            // 情况 2：a + b = value
            if (rest != num && freq.containsKey(rest)) {
                return true;
            }
        }
        return false;
    }
}