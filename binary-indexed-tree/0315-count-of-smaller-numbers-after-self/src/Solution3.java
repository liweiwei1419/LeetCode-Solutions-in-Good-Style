import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/2 11:19 上午
 */
public class Solution3 {

    /**
     * 插入排序 + 二分查找
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        int[] res = new int[len];
        // 在 temp 数组中找到第 1 个大于等于待插入元素的索引
        int[] temp = new int[len];
        temp[0] = nums[len - 1];
        res[len - 1] = 0;
        // end 指向即将写入的那个元素的位置
        int end = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > temp[end - 1]) {
                temp[end] = nums[i];
                res[i] = end;
            } else {

                // 先找到第 1 个大于等 target 的索引

                int left = 0;
                int right = end - 1;
                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (temp[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                // 这个时候就可以写入结果集了
                res[i] = left;

                // 插入排序，把它之后的全部后移一位
                int j = end - 1;
                while (j >= left) {
                    temp[j + 1] = temp[j];
                    j--;
                }
                temp[left] = nums[i];
            }
            end++;
        }


        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            result.add(res[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        Solution3 solution2 = new Solution3();
        List<Integer> res = solution2.countSmaller(nums);
        System.out.println(res);
    }
}
