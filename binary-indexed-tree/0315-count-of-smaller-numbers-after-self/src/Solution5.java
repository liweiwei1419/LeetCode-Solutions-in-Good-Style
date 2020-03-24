import java.util.ArrayList;
import java.util.List;


/**
 * 和 Solution4 是一致的
 */
public class Solution5 {

    private int[] nums;
    private int[] res;
    private int[] indexes;

    private void mergeAndCountSmaller(int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeAndCountSmaller(left, mid);
        mergeAndCountSmaller(mid + 1, right);
        mergeOfTwoSortedArrAndCountSmaller(left, mid, right);
    }

    // indexes[i] = j，表示排名第 i 个数据的元素下标是 j
    private void mergeOfTwoSortedArrAndCountSmaller(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int jump = 0;
        while (i <= mid || j <= right) {
            if (i > mid) {
                // i 用完了 j++
                temp[k++] = indexes[j++];
            } else if (j > right) {
                // j 用完了 i++
                res[indexes[i]] += jump;
                temp[k++] = indexes[i++];
            } else if (nums[indexes[i]] <= nums[indexes[j]]) {
                res[indexes[i]] += jump;
                temp[k++] = indexes[i++];
            } else {
                // nums[indexes[i]] > nums[indexes[j]]
                jump++;
                temp[k++] = indexes[j++];
            }
        }
        for (int p = 0; p < temp.length; p++) {
            indexes[left + p] = temp[p];
        }
    }

    /**
     * 完成排序是对 indexes 数组进行排序
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        if (len == 0) {
            return res;
        }
        this.nums = nums;
        this.res = new int[len];
        indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(this.res[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4};
        Solution2 solution2 = new Solution2();
        List<Integer> countSmaller = solution2.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
