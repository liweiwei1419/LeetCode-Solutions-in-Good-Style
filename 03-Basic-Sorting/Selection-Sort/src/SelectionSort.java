import java.util.Arrays;

public class SelectionSort {

    // 选择排序

    public static void main(String[] args) {
        int[] arr = {17, 15, 7, 9, 4};
        // 由于最后一个元素无后继元素，起始位置选择到最后一个元素的前 1 个就可以
        int len = arr.length;
        // 循环不变量 [0..i) 有序，且 arr[i - 1] < 区间 [i..len - 1] 里的所有元素
        for (int i = 0; i < len - 1; i++) {
            // 假设修正法（打擂台）：假设外层循环最小的那个元素的下标就是这一轮循环的第 1 个元素
            int minIndex = i;
            // 注意边界值 j < length，从 i 后面的元素开始，直到最后一个元素，都要参与比较
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        // 调试代码
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}