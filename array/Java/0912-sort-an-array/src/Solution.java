import java.util.ArrayList;
import java.util.List;

/**
 * 选择排序：每一轮选择最小元素交换到未排定部分的开头
 * 思想：贪心算法
 * 技巧：遍历一遍选出最值的算法，称之为打擂台算法，也叫假设修正法
 * 非稳定排序
 */
public class Solution {

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return arr2List(nums, len);
    }

    private List<Integer> arr2List(int[] nums, int len) {
        List<Integer> res = new ArrayList<>(len);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.sortArray(nums);
        System.out.println(res);
    }
}
