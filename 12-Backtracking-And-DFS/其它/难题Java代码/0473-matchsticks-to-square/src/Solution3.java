import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

    private int len;

    public boolean makesquare(int[] nums) {
        this.len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        // 边长
        int edge = sum / 4;
        // 记录了哪些火柴已经被使用
        boolean[] visited = new boolean[len];

        // 不想修改输入数组，所以将输入数组做了一份拷贝，想使用降序排序的 API，故使用包装类型
        Integer[] copy = new Integer[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy, Comparator.reverseOrder());
        return dfs(copy, visited, 0, edge, 0, 0);
    }

    public boolean dfs(Integer[] nums, boolean[] visited, int k, int edge, int begin, int tempSum) {
        if (k == 4) {
            return true;
        }
        if (tempSum == edge) {
            // 注意：需要从 begin = 0 开始搜索，有一些边是跳过的
            return dfs(nums, visited, k + 1, edge, 0, 0);
        }
        for (int i = begin; i < len; i++) {
            if (tempSum + nums[i] > edge) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                // 由于是按照顺序搜索的，下一轮搜索起点为 i + 1
                if (dfs(nums, visited, k, edge, i + 1, tempSum + nums[i])) {
                    return true;
                }
                visited[i] = false;

                // 长度相等的边都可以跳过
                while (i + 1 < len && nums[i].equals(nums[i + 1])) {
                    i++;
                }
            }
        }
        return false;
    }
}