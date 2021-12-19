/**
 * 原地堆排序
 */
public class HeapSort3 implements ISortAlgorithm {

    @Override
    public String getName() {
        return "原地堆排序";
    }


    /**
     * 原地堆排序的目标就是，不再借助 MaxHeap3 这个数据结构进行排序，减少了空间复杂度
     * 注意：此时我们的数组索引从 0 开始定义(自己在纸上画一下图，就能清晰地明白算法实现的含义)
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        // 首先 heapify：将一个无序的数组组成了一个最大堆，第 1 个元素就是最大值
        for (int i = (length - 1) / 2; i >= 0; i--) {
            siftDown(arr, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, i, 0);
        }
    }


    /**
     * 从索引为 end 开始，j 为止 [end,j] 的数组元素进行 shift down 的操作
     * 注意 shiftDown 不能复用我们上面写的，而设计成
     * 对 0 开始，end 为止，即将 arr 中 [0,end] 部分的数组元素视为"最大堆"
     * 对索引为 j 的元素进行 shift down 的操作
     *
     * @param arr
     * @param end
     * @param j
     */
    private void siftDown(int[] arr, int end, int j) {
        // 如果有右孩子的节点，并且右孩子节点比左孩子节点的值要大
        // 此时可以忽略左孩子节点的存在，拿右孩子节点的数值和自己比较
        // 只要它有左孩子，就不是叶子节点，就可能 shift down，注意：这里是小于号
        while (2 * j + 1 < end) {
            int k = 2 * j + 1;
            if (k + 1 < end && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            if (arr[j] < arr[k]) {
                swap(arr, j, k);
                // 留意
                j = k;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
