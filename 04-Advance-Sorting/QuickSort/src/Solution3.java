import java.util.Random;

public class Solution3 {

    /**
     * 静态常量命名的时候全部使用大写字母
     */
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right) {
        // 注意：这里包括 > 的情况，与归并排序不同，请通过调试理解这件事情
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }


    /**
     * 目标：与切分元素相等的元素均匀地分布在切分元素最终所在位置的两侧
     * 这个定义非常重要，直接影响我们的算法初始值定义
     * [left + 1, i) 全部小于标定点
     * (j, right] 全部大于标定点
     * 在指针对撞的过程中，和标定点相同的元素就被挤到了中间
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(arr, randomIndex, left);

        // 循环不变量，le = less equals，ge = great equals
        // all in [left + 1, le) <= pivot
        // all in (ge, right] >= pivot
        // le > ge 的时候终止
        int pivot = arr[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            // 注意：这里一定是 arr[le] < pivot，等于 pivot 的元素是被交换过来得到的
            while (le <= ge && arr[le] < pivot) {
                le++;
            }
            // 此时 le 来到第 1 个大于等于 pivot 的位置
            while (le <= ge && arr[ge] > pivot) {
                ge--;
            }
            // 此时 ge 来到第 1 个小于等于 pivot 的位置
            if (le > ge) {
                break;
            }

            swap(arr, le, ge);
            le++;
            ge--;
        }
        swap(arr, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}