public class Solution {

    // 思想：分治，同类问题「数组中的逆序对」

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 这一行不能要，反例：[-5,-5] 输出：1
//        if (nums[mid] <= nums[mid + 1]) {
//            return leftPairs + rightPairs;
//        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;

    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // 第 1 步：双指针空转一次，不修改 temp 数组
        int i = left;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= right) {
            // nums[i] > 2 * nums[j] 防止乘 2 溢出，所以进行类型转换
            if ((long) temp[i] > 2 * (long) temp[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // 第 2 步：然后重置、归并（和归并排序、计算逆序数一样）
        i = left;
        j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
        return count;
    }
}