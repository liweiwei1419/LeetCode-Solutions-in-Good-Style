import java.util.Arrays;

public class ShellSort2 {

    /**
     * 希尔排序（shell sort）2：来自《算法》（第 4 版）
     * @param arr
     */
    public void sort(int[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // insertion sort
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {8, 4, 3, 6, 5, 1};
        ShellSort2 shellSort2 = new ShellSort2();
        shellSort2.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
