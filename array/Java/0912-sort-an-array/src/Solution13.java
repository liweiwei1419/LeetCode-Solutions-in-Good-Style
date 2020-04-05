import java.util.Arrays;

public class Solution13 {

    public int[] sortArray(int[] nums) {

        int size = nums.length;
        // System.out.println(size);
        quickSort(nums, 0, size - 1);

        return nums;

    }

    private void quickSort(int[] a, int left, int right) {
        // System.out.println("left = " + left + ", right = " + right);

        if (left >= right) {
            return;
        }

        // left 这个位置已经被看到，故从 left + 1 开始看
        int l = left + 1;
        int r = right;
        int pivot = a[left];

        while (true) {
            // 右边找小的
            while (l <= r && a[r] >= pivot) {
                r--;
            }
            // 左边找大的
            while (l <= r && a[l] <= pivot) {
                l++;
            }

            // 交换两个数
            if (l >= r) {
                break;
            }

            int t = a[l];
            a[l] = a[r];
            a[r] = t;

            l++;
            r--;
        }
        //将基准数归位
        a[left] = a[r];
        a[r] = pivot;

        // System.out.println(Arrays.toString(a));
        //递归排序左右子序列
        quickSort(a, left, r - 1);
        quickSort(a, r + 1, right);
    }

    public static void main(String[] args) {
        // int[] nums = {5, 2, 3, 1};
        // int[] nums = {4, 1, 5, 6, 2, 7, 3};
        int[] nums = {-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39};
        Solution13 solution13 = new Solution13();
        int[] res = solution13.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
