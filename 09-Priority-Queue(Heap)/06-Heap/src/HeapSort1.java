/**
 * 第 1 个版本的堆排序算法
 */
public class HeapSort1 implements ISortAlgorithm {

    @Override
    public String getName() {
        return "第 1 个版本的堆排序算法，逐个全部入队，再逐个出队";
    }


    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        MaxHeap maxHeap = new MaxHeap(length);
        for (int i = 0; i < length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }


    /**
     * 把数组中的元素先全部挨个 insert 到最大堆中
     * 然后在依次取出，因为每次取出的都是剩下的元素中的最大者
     * 因此应该倒着覆盖到原待排序数组
     *
     * @param nums
     */
    public void sort1(int[] nums) {
        int[] temp = nums.clone();
        MaxHeap maxHeap = new MaxHeap(nums.length);
        for (Integer item : temp) {
            maxHeap.insert(item);
        }
        while (maxHeap.getSize() > 0) {
            nums[maxHeap.getSize() - 1] = maxHeap.extractMax();
        }
    }
}
