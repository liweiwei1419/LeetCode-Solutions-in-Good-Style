import java.util.Random;

public class Solution2 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;


        randomShuffle(nums);

        int lo = 0;
        int hi = nums.length - 1;
        int m = nums.length - k;   // find the length-k smallest element


        while (true) { // why is hi> lo?


            int j = patrition(nums, lo, hi);
            if (j < m) lo = j + 1;
            else if (j > m) hi = j - 1;
            else return nums[j];
        }

    }

    public int patrition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int key = arr[lo];
        while (true) {
            while (arr[++i] < key) {
                if (i == hi) break;
            }
            while (arr[--j] > key) {
                if (j == lo) break;
            }
            if (j <= i) break; //patrition complete

            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
        }

        arr[lo] = arr[j];
        arr[j] = key;

        return j;
    }

    public void randomShuffle(int[] nums) {

        Random rd = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = rd.nextInt(i + 1);
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        return;
    }
}