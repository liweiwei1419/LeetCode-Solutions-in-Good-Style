import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution4 {

    // 剪枝用加法

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1、首先要排序，目的：快速剪枝
        Arrays.sort(candidates);
        Deque<Integer> stack = new ArrayDeque<>();

        // 2、需要一个变量记录下一轮搜索的起始索引
        backtracking(candidates, stack, 0, 0, target);
        return res;
    }

    public void backtracking(int[] candidates, Deque<Integer> ans,
                             int start, int currentSum, int target) {
        if (currentSum == target) {
            // 对于 Java 而言，方法传递的是引用，因此，需要创建一个新对象，把当前 ans 保存下来
            res.add(new ArrayList<>(ans));
            return; // 直接退出，语义更清晰
        }

        for (int i = start; i < candidates.length; i++) {
            // 5、因为是升序排序，只要当前 candidates[i] 加上去大于 target，后面的 candidates[i] 都不用看了
            if (currentSum + candidates[i] > target) {
                break;
            }
            ans.add(candidates[i]);
            currentSum += candidates[i];

            // 3、注意：因为一个数可以重复使用多次，因此，每次尝试搜索的起始索引还是 start，
            backtracking(candidates, ans, i, currentSum, target);

            // 4、每一次尝试以后要状态重置，代码与 backtrack 之前是对称的，列表最后添加了元素就要删除，累计和加上了就得减去
            currentSum -= candidates[i];
            ans.pop();
        }
    }
}
