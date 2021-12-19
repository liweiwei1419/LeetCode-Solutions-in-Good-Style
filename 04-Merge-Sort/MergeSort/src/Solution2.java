import java.util.Arrays;

public class Solution2 {

    // 调试的代码

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1, 0);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int depthForDebug) {
        System.out.println(" ".repeat(depthForDebug) + "拆分 (" + left + ", " + right + ")");
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, depthForDebug + 1);
        mergeSort(nums, mid + 1, right, depthForDebug + 1);
        System.out.println(" ".repeat(depthForDebug) + "合并 (" + left + ", " + right + ")");
        mergeOfTwoSortedArray(nums, left, mid, right);
    }


    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[i] = nums[left + i];
        }

        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            if (i == mid + 1 - left) {
                nums[left + k] = temp[j];
                j++;
            } else if (j == right + 1 - left) {
                nums[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[left + k] = temp[i];
                i++;
            } else {
                nums[left + k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] res = solution2.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}