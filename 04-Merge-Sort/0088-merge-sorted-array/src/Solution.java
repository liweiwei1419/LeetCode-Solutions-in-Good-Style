public class Solution {

    // 这道题真正想考查的从后向前归并的实现方式

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int i = m - 1;
        int j = n - 1;
        // 从后向前归并，比较 nums1 和 nums2 末尾的元素哪个大，谁大谁出列，覆盖 nums1
        for (int k = len - 1; k >= 0; k--) {
            if (i == -1) {
                // 注意：同样要把 nums1 和 nums2 归并完成的逻辑写在前面，否则会出现数组下标越界异常
                // 此时 j 位于数组 nums2 的末尾索引位置，还未看的数组 nums2 的长度为 j + 1
                // 复制完 break 掉即可
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
                break;
            } else if (j == -1) {
                // 注意：这里直接 break 掉就可以了
                // 因为 nums2 遍历完成以后，nums1 剩下的元素虽然还没有看，但一定是排定以后的那个样子
                break;
            } else if (nums1[i] >= nums2[j]) {
                // 谁大谁出列
                nums1[k] = nums1[i];
                i--;
            } else {
                assert nums1[i] < nums2[j];
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}