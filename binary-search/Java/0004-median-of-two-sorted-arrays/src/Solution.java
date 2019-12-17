public class Solution {

    // 不符合题目时间复杂度要求的做法，是常规思路

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 最后要找到合并以后索引是 median_index 的这个数
        int medianIndex = (m + n) >>> 1;

        // 计数器从 -1 开始，在循环开始之前加 1
        // 这样在退出循环的时候，counter 能指向它最后赋值的那个元素
        int counter = -1;

        // nums1 的索引
        int i = 0;
        // nums2 的索引
        int j = 0;

        int[] res = new int[]{0, 0};
        while (counter < medianIndex) {
            counter++;
            // 先写 i 和 j 遍历完成的情况，否则会出现数组下标越界
            if (i == m) {
                res[counter & 1] = nums2[j];
                j++;
            } else if (j == n) {
                res[counter & 1] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                res[counter & 1] = nums1[i];
                i++;
            } else {
                res[counter & 1] = nums2[j];
                j++;
            }
        }

        // 如果 m + n 是奇数，median_index 就是我们要找的
        // 如果 m + n 是偶数，有一点麻烦，要考虑其中有一个用完的情况，其实也就是把上面循环的过程再进行一步
        if (((m + n) & 1) == 1) {
            return res[counter & 1];
        } else {
            return (double) (res[0] + res[1]) / 2;
        }
    }
}
