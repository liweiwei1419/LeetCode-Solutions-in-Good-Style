import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    // 方法一：回溯算法（超时）

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) &&
                    Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    private Map<Pair<Integer, Integer>, Integer> memo;

    // 记忆化搜索：超时

    /**
     * dfs
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        memo = new HashMap<>();
        return dfs(nums, S, 0, nums.length);
    }

    private int dfs(int[] nums, int S, int index, int len) {
        if (index == len) {
            if (S == 0) {
                return 1;
            }
            return 0;
        }
        if (memo.containsKey(new Pair<>(index, S))) {
            return memo.get(new Pair<>(index, S));
        }
        int res = 0;
        int left = dfs(nums, S - nums[index], index + 1, len);
        int right = dfs(nums, S + nums[index], index + 1, len);
        res += (left + right);
        memo.put(new Pair<>(S, index), res);
        return res;
    }
}