public class Solution {

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

        // 这一行不能要
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

        int i = left;
        int j = mid + 1;

        // 首先要空转一次
        int count = 0;
        while (i <= mid && j <= right) {

            // 巨多坑，nums[i] > 2 * nums[j] 防止乘 2 溢出
            if ((long) temp[i] > 2 * (long) temp[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // 然后重置，归并
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2, 3, 1};
        int res = solution.reversePairs(nums);
        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);

        System.out.println(Math.log(10000)/Math.log(2));
    }
}
