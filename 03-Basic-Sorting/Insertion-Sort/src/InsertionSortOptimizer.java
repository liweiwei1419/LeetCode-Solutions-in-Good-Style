import java.util.Arrays;

public class InsertionSortOptimizer implements ISortAlgorithm {
    @Override
    public String getName() {
        return "插入排序（优化）";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] <= arr[i]) {
                continue;
            }
            int temp = arr[i];
            int j = i;
            // 逐个后移
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        int testTimes = 3;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = SortTestHelper.generateRandomArray(100000, 1, 2000);
            int[] copyFromOldArray = SortTestHelper.copyFromOldArray(randomArray);

            SortTestHelper.testSortEfficiency(new InsertionSortOptimizer(), randomArray);
            Arrays.sort(copyFromOldArray);
            SortTestHelper.judgeArrayEquals(randomArray, copyFromOldArray);
            System.out.println();
        }
    }
}
