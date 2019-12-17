// 不符合题目时间复杂度要求的做法
// 但是是常规思路

import java.util.Arrays;

public class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] merge = new int[m + n];
        System.arraycopy(nums1, 0, merge, 0, m);
        System.arraycopy(nums2, 0, merge, m, n);

        Arrays.sort(merge);

        if (((m + n) & 1) == 1) {
            return merge[(m + n - 1) >>> 1];
        } else {
            return (double) (merge[(m + n - 1) >>> 1] + merge[(m + n) >>> 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Solution2 solution2 = new Solution2();
        double res = solution2.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
