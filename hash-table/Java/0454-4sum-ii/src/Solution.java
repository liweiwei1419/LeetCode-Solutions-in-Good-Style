import java.util.HashMap;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // key 是 A 和 B 数组分别取一个数可能的和，value 是这个和可能由几个不同的组合
        HashMap<Integer, Integer> map = new HashMap<>();
        // 计数器
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        for (int c : C) {
            for (int d : D) {
                int target = -c - d;
                if (map.containsKey(target)) {
                    res += map.get(target);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        Solution solution = new Solution();
        int fourSumCount = solution.fourSumCount(A, B, C, D);
        System.out.println(fourSumCount);
    }
}