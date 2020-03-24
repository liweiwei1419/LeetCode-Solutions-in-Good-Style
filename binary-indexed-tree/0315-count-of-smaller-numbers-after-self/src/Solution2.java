import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/2 11:19 上午
 */
public class Solution2 {


    /**
     * 插入排序
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
                // 插入排序
                int j = end;
                int tempVal = nums[i];
                while (j > 0 && temp[j - 1] >= tempVal) {
                    temp[j] = temp[j - 1];
                    j--;
                }
                temp[j] = tempVal;
                res[i] = j;
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
        int[] nums = {2, 0, 1};
        Solution2 solution2 = new Solution2();
        List<Integer> res = solution2.countSmaller(nums);
        System.out.println(res);
    }
}
