public class Solution2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        // 只需要把 nums1 的有效个元素复制到 nums3 就可以了
        System.arraycopy(nums1, 0, nums3, 0, m);
        // 数组3
        int i = 0;
        // 数组2
        int j = 0;
        int length = m + n;
        // 从前向后归并，比较 nums3 和 nums2 前端的元素哪个小，谁小谁出列，覆盖 nums1
        for (int k = 0; k < length; k++) {
            // 注意：要把 nums3 和 nums2 归并完成的逻辑写在前面，否则会出现数组下标越界异常
            if (i == m) {
                nums1[k] = nums2[j];
                j++;
            } else if (j == n) {
                nums1[k] = nums3[i];
                i++;
            } else if (nums3[i] < nums2[j]) {
                nums1[k] = nums3[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }
}