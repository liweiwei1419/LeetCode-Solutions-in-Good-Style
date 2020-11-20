public class Solution2 {

    // 「力扣」第 912 题：排序数组  

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 第 1 步：先整理成最大堆
        heapify(nums, len);

        // 第 2 步：先交换，再将堆顶元素下沉
        // 注意：这里 i 表示当前二叉树所表示的数组的结尾下标
        for (int i = len - 1; i >= 1; ) {
            swap(nums, 0, i);
            i--;
            siftDown(nums, 0, i);
        }
        return nums;
    }

    private void heapify(int[] nums, int len) {
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}