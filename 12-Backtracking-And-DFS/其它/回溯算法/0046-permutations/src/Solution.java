import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    /**
     * @param nums  候选数字列表
     * @param len   列表长度，可以直接从 nums.length 里获取，因为需要使用的次数很多，设计这个冗余的变量
     * @param depth 已经选了几个数字
     * @param path  已经选择的数字列表
     * @param used  快速判断某个数是否已经被选择
     * @param res   记录结果集的列表
     */
    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            // 无需拷贝
            res.add(new ArrayList<>(path));
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            // 在每一个结点创建新变量有一定性能消耗
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[i]);

            boolean[] newUsed = new boolean[len];
            System.arraycopy(used,0,newUsed,0,len);
            newUsed[i] = true;

            dfs(nums, len, depth + 1, newPath, newUsed, res);
            // 无回溯过程
        }
    }
}