import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/12/3 3:58 下午
 */
public class Solution {

    // 暴力解法
    // 时间复杂度：O(NM)
    // 空间复杂度：O(N)
    // 没有重复元素是关键

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1];
        if (len1 < 1) {
            return res;
        }

        for (int i = 0; i < len1; i++) {
            int curVal = nums1[i];
            int j = 0;
            while (j < len2 && nums2[j] != curVal) {
                j++;
            }

            // 此时 nums[j] = nums[i]
            j++;
            while (j < len2 && nums2[j] < curVal) {
                j++;
            }

            if (j == len2) {
                res[i] = -1;
                continue;
            }
            res[i] = nums2[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Solution solution = new Solution();
        int[] res = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
