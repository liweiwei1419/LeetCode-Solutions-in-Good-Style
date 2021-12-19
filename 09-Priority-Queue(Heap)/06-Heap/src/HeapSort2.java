/**
 * 第 2 个版本的堆排序算法
 */
public class HeapSort2 implements ISortAlgorithm {

    @Override
    public String getName() {
        return "第 2 个版本的堆排序算法，传入数组入队，在逐个出队";
    }


    @Override
    public void sort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}
