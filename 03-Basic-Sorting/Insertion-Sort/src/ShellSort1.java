import java.util.Arrays;

public class ShellSort1 {

    /**
     * 希尔排序（shell sort）1：增量每次除以 2 递减
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        int delta = len / 2;
        while (delta >= 1) {
            // 特别注意边界的选取，可以代入具体的值验证，要有耐心 debug
            for (int i = len - 1; i >= len - delta; i--) {
                for (int j = i; j >= delta; j -= delta) {
                    if (arr[j - delta] > arr[j]) {
                        swap(arr, j - delta, j);
                    }
                }
            }
            // System.out.println("排序过程：" + Arrays.toString(arr));
            delta /= 2;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {8, 4, 3, 6, 5, 1, 9, 7};
        ShellSort1 shellSort1 = new ShellSort1();
        shellSort1.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
