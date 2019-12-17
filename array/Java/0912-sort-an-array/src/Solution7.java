import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/22 12:10 上午
 */
public class Solution7 {

    // 桶排序
    // 1 <= A.length <= 10000
    // -50000 <= A[i] <= 50000

    // 10_0000

    private static final int OFFSET = 50000;

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        // 第 1 步：将数据转换为 [0, 10_0000] 区间里的数
        for (int i = 0; i < len; i++) {
            nums[i] += OFFSET;
        }

        // 第 2 步：观察数据，设置桶的个数
        // 步长：步长如果设置成 10 会超出内存限制
        int step = 1000;
        // 桶的个数
        int bucketLen = 10_0000 / step;

        int[][] temp = new int[bucketLen + 1][len];
        int[] next = new int[bucketLen + 1];

        // 第 3 步：分桶
        for (int i = 0; i < len; i++) {
            int bucketIndex = nums[i] / step;
            temp[bucketIndex][next[bucketIndex]] = nums[i];
            next[bucketIndex]++;
        }

        // 第 4 步：对于每个桶执行插入排序
        for (int i = 0; i < bucketLen + 1; i++) {
            insertionSort(temp[i], next[i] - 1);
        }

        // 第 5 步：从桶里依次取出来
        List<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < bucketLen + 1; i++) {
            int curLen = next[i];
            for (int j = 0; j < curLen; j++) {
                res.add(temp[i][j] - OFFSET);
            }
        }
        return res;
    }

    private void insertionSort(int[] arr, int endIndex) {
        for (int i = 1; i <= endIndex; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

    }

}
