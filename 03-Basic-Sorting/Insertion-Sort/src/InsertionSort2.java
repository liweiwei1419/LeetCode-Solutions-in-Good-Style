import java.util.Arrays;

public class InsertionSort2 implements ISortAlgorithm {

    @Override
    public String getName() {
        return "插入排序";
    }

    /**
     * 与 InsertionSort 等价的写法
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // 第 1 轮的时候，第 1 个数可以认为是排好序的
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int testTimes = 3;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = SortTestHelper.generateRandomArray(100000, 1, 2000);
            int[] copyFromOldArray = SortTestHelper.copyFromOldArray(randomArray);

            SortTestHelper.testSortEfficiency(new InsertionSort2(), randomArray);
            Arrays.sort(copyFromOldArray);
            SortTestHelper.judgeArrayEquals(randomArray, copyFromOldArray);
            System.out.println();
        }
    }
}