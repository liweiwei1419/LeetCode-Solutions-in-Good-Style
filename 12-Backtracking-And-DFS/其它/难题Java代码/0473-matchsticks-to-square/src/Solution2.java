import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    // 参考资料：https://leetcode-cn.com/problems/matchsticks-to-square/solution/java-1ms-tao-yong-hui-su-mo-ban-ji-zhi-de-jian-zhi/

    private boolean[] visited;

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum == 0 || sum % 4 != 0) {
            return false;
        }

        // 边长
        int edge = sum / 4;
        int len = nums.length;
        visited = new boolean[len];
        Integer[] copy = new Integer[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy, Comparator.reverseOrder());
        return dfs(0, edge, 0, 0, copy);
    }


    /**
     * @param index   表示当前是第几条边，总共四条边
     * @param edge    边长度
     * @param tempSum 表示当前边已经到多少长度了
     * @param begin   人为规定一个遍历的顺序，防止重复
     * @param nums    降序排序的木棍数组
     * @return
     */
    boolean dfs(int index, int edge, int tempSum, int begin, Integer[] nums) {
        if (index == 4) {
            return true;
        }
        // tempSum 到达len，就可以换条边摆了
        if (tempSum == edge) {
            return dfs(index + 1, edge, 0, 0, nums);
        }

        for (int i = begin; i < nums.length; i++) {
            if (!visited[i] && tempSum + nums[i] <= edge) {
                visited[i] = true;
                if (dfs(index, edge, tempSum + nums[i], i + 1, nums)) {
                    return true;
                }
                visited[i] = false;

                // 能够走到这一步，说明这根火柴不行，否则已经return了
                // 相等的火柴也不行
                while (i + 1 < nums.length && nums[i + 1].equals(nums[i])) {
                    i++;
                }

                // 下面这两个剪枝条件可以省略
                // 如果这条火柴是边的第一条，那说明在这条边的任意一个位置都不行，那说明这一整个方案也不行
                if (tempSum == 0) {
                    return false;
                }
                // 如果是最后一条，同理
                if (tempSum + nums[i] == edge) {
                    return false;
                }
            }
        }
        return false;
    }
}