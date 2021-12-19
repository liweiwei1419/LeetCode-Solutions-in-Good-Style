import java.util.Arrays;

public class Solution {

    private int len;
    private boolean[] visited;
    private int[] nums;

    public boolean makesquare(int[] nums) {
        int len = nums.length;
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
        this.len = len;
        this.visited = new boolean[len];
        this.nums = nums;
        Arrays.sort(nums);
        return dfs(0, edge, 0, 1);
    }


    /**
     * @param index
     * @param target
     * @param tempSum
     * @param groupId
     * @return tempSum 是否可以拼接出边长为 target
     */
    private boolean dfs(int index, int target, int tempSum, int groupId) {
        if (groupId == 4) {
            return true;
        }

        if (tempSum == target) {
            // 注意：又从 0 开始搜索
            return dfs(0, target, 0, groupId + 1);
        }

        if (tempSum > target) {
            return false;
        }

        for (int i = index; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            // 这个剪枝参考第 47 题
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            if (dfs(i + 1, target, tempSum + nums[i], groupId)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}