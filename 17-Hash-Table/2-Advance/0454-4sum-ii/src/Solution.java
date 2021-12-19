import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // key 是 A 和 B 数组分别取一个数可能的和，value 是这个和可能由几个不同的组合
        Map<Integer, Integer> map = new HashMap<>();
        // 第 1 步：把 A 和 B 所有的组合存入哈希表
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum , map.getOrDefault(sum, 0) + 1);
            }
        }

        // 第 2 步：计算 C 和 D 的所有组合的相反数
        // 计数器
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int target = -c - d;
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}