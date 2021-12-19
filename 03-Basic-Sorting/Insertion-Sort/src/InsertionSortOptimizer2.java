import java.util.Arrays;

public class InsertionSortOptimizer2 implements ISortAlgorithm {
    @Override
    public String getName() {
        return "插入排序（优化）";
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            // 从 i 开始，就看前面的，正因为看前面的，边界条件才是 j > 0
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        int testTimes = 3;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = SortTestHelper.generateRandomArray(100000, 1, 2000);
            int[] copyFromOldArray = SortTestHelper.copyFromOldArray(randomArray);

            SortTestHelper.testSortEfficiency(new InsertionSortOptimizer2(), randomArray);
            Arrays.sort(copyFromOldArray);
            SortTestHelper.judgeArrayEquals(randomArray, copyFromOldArray);
            System.out.println();
        }
    }
}
