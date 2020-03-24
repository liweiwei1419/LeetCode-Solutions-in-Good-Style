import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 接下来把递归改成动态规划，使用 Hash 表
    // 使用动态的红黑树就不会 超出内存限制 了

    public int integerReplacement(int n) {
        // 0 要占一个位子，所以要给出 n+1 个位子
        if (n <= 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        return helper(n, map);
    }

    private int helper(int n, Map<Integer, Integer> map) {
        Integer value = map.get(n);
        if (value == null) {
            if (n % 2 == 0) {
                value = helper(n / 2, map) + 1;
            } else {
                // n-1 /2
                // n+1 /2
                value = 2 + Math.min(helper(n / 2, map), helper(n / 2 + 1, map));
            }
        }
        return value;
    }
}
