import java.util.Arrays;

public class Solution {

    // 知识点：快速排序
    // 最小的 k 个数的：即下标区间为 [0, k - 1] 的这些数
    // 使用 partition 过程找到下标为 k - 1 的那个数即可

    // 缺点：一次性得将所有元素读入内存
    // 时间复杂度：O(N \logN)
    // 空间复杂度：O(1)

    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if (k == 0 || k > len) {
            return new int[0];
        }

        int target = k - 1;
        int left = 0;
        int right = len - 1;

        while (true) {
            int pIndex = partition(arr, left, right);

            if (pIndex == target) {
                int[] res = new int[k];
                System.arraycopy(arr, 0, res, 0, k);
                return res;
            } else if (pIndex < target) {
                // 下一轮搜索区间在 [pIndex + 1, right]
                left = pIndex + 1;
            } else {
                // pIndex > target
                // 下一轮搜索区间在 [left, pIndex - 1]
                right = pIndex - 1;
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 这里最好随机化

        // 循环不变量定义
        // [left + 1, lt] < pivot
        // (lt, i) >= pivot
        int pivot = arr[left];
        int lt = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                lt++;
                swap(arr, lt, i);
            }
        }
        swap(arr, left, lt);
        return lt;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 0, 5};
        int k = 0;

        Solution solution = new Solution();
        int[] res = solution.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
