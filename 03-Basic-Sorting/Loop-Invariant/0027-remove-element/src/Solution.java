public class Solution {

    // 思路：常规题，只要不等于指定元素，就交换，等于就放过

    public int removeElement(int[] nums, int val) {
        // 定义 [0, j) 这个区间里的数满足 不等于 val，所以是先交换，再 ++
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, j, i);
                j++;
            }
        }
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}