import java.util.Random;

public class Solution3 {


    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);


        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, le) <= pivot
        // (ge, right] >= pivot

        int le = left + 1;
        int ge = right;

        while (true) {
            // 遇到 nums[le] >= pivot 的时候停下来
            // 遇到与 pivot 相等的元素，是通过交换被等概率分到两边的
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le > ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        // 这里还要交换，注意是 ge
        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
