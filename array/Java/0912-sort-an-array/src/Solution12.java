import java.util.ArrayList;
import java.util.List;

/**
 * 堆排序
 */
public class Solution12 {

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

    private void heapify(int[] nums, int len) {
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        heapify(nums, len);

        for (int i = len - 1; i >= 1; ) {
            swap(nums, 0, i);
            i--;
            siftDown(nums, 0, i);
        }
        return arr2List(nums, len);
    }

    private List<Integer> arr2List(int[] nums, int len) {
        List<Integer> res = new ArrayList<>(len);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution12 solution12 = new Solution12();
        List<Integer> res = solution12.sortArray(nums);
        System.out.println(res);
    }
}

