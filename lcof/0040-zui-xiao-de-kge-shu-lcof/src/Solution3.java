import java.util.Arrays;

public class Solution3 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if (k == 0 || k > len) {
            return new int[0];
        }

        int left = 0;
        int right = len - 1;
        int target = k - 1;
        // 考虑边界条件
        while (true) {
            System.out.println(left + " " + right);

            int pIndex = partition(arr, left, right);
            System.out.println(pIndex);
            if (pIndex < target) {
                left = pIndex + 1;
            } else if (pIndex > target) {
                right = pIndex - 1;
            } else {
                // assert pIndex == k - 1;
                int[] res = new int[k];
                System.arraycopy(arr, 0, res, 0, k);
                return res;
            }
        }

    }

    private int partition(int[] nums, int left, int right) {
        // 可以随机选取
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, lt, left);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 0, 5};
        int k = 0;

        Solution3 solution3 = new Solution3();
        int[] res = solution3.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
