public class QuickSort implements ISortAlgorithm {

    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    /**
     * @param arr
     * @param left  可以取到
     * @param right 可以取到
     */
    private void quickSort(int[] arr, int left, int right) {
        // 递归终止条件，一定要写，否则就变成死循环了
        // 待优化 2 ：小数组的时候，使用插入排序
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    // 从标定点后面一个一个地比较到底，遇到比标定元素大的，就放过，遇到比标定元素小的或者等于的，就依次放在标定元素的后面
    // 从一个具体的例子出发，就能正确地写出代码，例如：
    // 3, 4, 6, 2, 1, 8, 5, 7
    // 3, 2, 6, 4, 1, 8, 5, 7
    // 3, 2, 1, 4, 6, 8, 5, 7
    // 1, 2, 3, 4, 6, 8, 5, 7

    /**
     * 将起始的元素作为标定点
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        // 待优化 1 ：随机选择一个点作为标定点
        int povit = arr[left];
        // 起始点不能设置为 left + 1，因为很有可能后面的元素都比它大
        // 在这种情况下，这一次 partition 不用交换元素的位置
        int k = left;
        // 注意，这里取等号
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < povit) {
                // 交换当前元素与 k 的位置
                k++;
                swap(arr, i, k);
            }
        }
        // 最后这一步要记得交换标定点位置
        swap(arr, left, k);
        return k;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20, 1, 100);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        SortHelper.checkSorted(nums);
    }
}
