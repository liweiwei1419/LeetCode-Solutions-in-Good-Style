import java.util.ArrayList;
import java.util.List;


public class Solution8 {

    // 调试代码

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>(len);
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums,  len,0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len,int depth, List<Integer> path,  boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                boolean[] newUsed = new boolean[len];
                System.arraycopy(used,0,newUsed,0,len);
                newUsed[i] = true;

                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                dfs(nums, len, depth + 1,  newPath,newUsed, res);
                // 因为每一次都创建新的状态变量描述某一时刻的进展，因此，无需“回溯”（状态重置，回到过去）
            }
        }
    }
}
