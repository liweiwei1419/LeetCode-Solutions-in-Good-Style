import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

    // 仅供参考，isRepeat() 函数线性扫描，复杂度高

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(num);
        }
        int len = nums.length;
        backtracking(len, numsArr, res, 0);
        return res;

    }

    private void backtracking(int len, List<Integer> nums,
                              List<List<Integer>> res, int index) {

        if (index == len) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!isRepeat(nums, index, i)) {
                Collections.swap(nums, index, i);
                backtracking(len, nums, res, index + 1);
                Collections.swap(nums, index, i);
            }
        }

    }

    /**
     * 线性复杂度
     *
     * @param nums
     * @param first
     * @param n
     * @return
     */
    private boolean isRepeat(List<Integer> nums, int first, int n) {
        int temp = nums.get(n);
        for (int i = first; i < n; i++) {
            if (nums.get(i) == temp) {
                return true;
            }
        }
        return false;
    }
}
