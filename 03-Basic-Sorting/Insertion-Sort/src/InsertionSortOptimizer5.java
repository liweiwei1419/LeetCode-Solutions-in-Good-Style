import java.util.Arrays;

public class InsertionSortOptimizer5 implements ISortAlgorithm {
    @Override
    public String getName() {
        return "插入排序（优化）";
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            // 从 i - 1 开始，就看当前的，所以边界条件是 j >= 0
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        int testTimes = 3;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = SortTestHelper.generateRandomArray(100000, 1, 2000);
            int[] copyFromOldArray = SortTestHelper.copyFromOldArray(randomArray);

            SortTestHelper.testSortEfficiency(new InsertionSortOptimizer5(), randomArray);
            Arrays.sort(copyFromOldArray);
            SortTestHelper.judgeArrayEquals(randomArray, copyFromOldArray);
            System.out.println();
        }
    }
}
