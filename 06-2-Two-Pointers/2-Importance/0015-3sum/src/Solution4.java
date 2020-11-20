import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {

    class Tuple {
        private int a;
        private int b;
        private int c;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        Arrays.sort(nums);
        dfs(res, path, nums, sum, used, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int sum, boolean[] used, int begin) {
        if (path.size() == 3) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            used[i] = true;
            dfs(res, path, nums, sum + nums[i], used, begin++);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}