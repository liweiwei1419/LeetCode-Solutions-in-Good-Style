import java.util.Arrays;

public class InsertionSort implements ISortAlgorithm {

    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // 循环不变量：区间 [0..i) 有序，每一轮循环将 arr[i] 插入区间 [0..i) 使得它成为长度更长的有序数组
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    // 注意：前面的数严格大于后面的数才交换
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
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

            SortTestHelper.testSortEfficiency(new InsertionSort(), randomArray);
            Arrays.sort(copyFromOldArray);
            SortTestHelper.judgeArrayEquals(randomArray, copyFromOldArray);
            System.out.println();
        }
    }
}