public class Solution4 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
        MaxHeap maxHeap = new MaxHeap(len);
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.pop();
        }
        return maxHeap.peek();

    }

    private class MaxHeap {
        int[] maxHeap;
        int heapSize;
        int realSize = 0;

        public MaxHeap(int heapSize) {
            this.heapSize = heapSize;
            maxHeap = new int[heapSize + 1];
            maxHeap[0] = 0;
        }

        public void add(int element) {
            realSize++;
            if (realSize > heapSize) {
                realSize--;
                return;
            }
            maxHeap[realSize] = element;

            int index = realSize;
            // 注意：如果用数组表示完全二叉树的时候，当完全二叉树的根节点存储在数组的索引1的位置时。
            int parent = index / 2;
            // 当添加的元素大于父节点时，需要将父节点的值和新增元素的值交换
            while (maxHeap[index] > maxHeap[parent] && index > 1) {
                int temp = maxHeap[index];
                maxHeap[index] = maxHeap[parent];
                maxHeap[parent] = temp;
                index = parent;
                parent = index / 2;
            }
        }

        // 获取堆顶元素函数
        public int peek() {
            return maxHeap[1];
        }

        // 删除堆顶元素函数
        public int pop() {
            // 如果当前「堆」的元素个数为0， 则返回「Don't have any element」
            if (realSize < 1) {
                // System.out.println("Don't have any element!");
                return Integer.MIN_VALUE;
            } else {
                // 当前「堆」中含有元素
                // realSize >= 1
                int removeElement = maxHeap[1];
                // 将「堆」中的最后一个元素赋值给堆顶元素
                maxHeap[1] = maxHeap[realSize];
                realSize--;
                int index = 1;
                // 当删除的元素不是孩子节点时
                while (index < realSize && index <= realSize / 2) {
                    // 被删除节点的左孩子节点
                    int left = index * 2;
                    // 被删除节点的右孩子节点
                    int right = (index * 2) + 1;
                    // 当删除节点的元素小于 左孩子节点或者右孩子节点，代表该元素的值小，此时需要将该元素与左、右孩子节点中最大的值进行交换
                    if (maxHeap[index] < maxHeap[left] || maxHeap[index] < maxHeap[right]) {
                        if (maxHeap[left] > maxHeap[right]) {
                            int temp = maxHeap[left];
                            maxHeap[left] = maxHeap[index];
                            maxHeap[index] = temp;
                            index = left;
                        } else {
                            // maxHeap[left] <= maxHeap[right]
                            int temp = maxHeap[right];
                            maxHeap[right] = maxHeap[index];
                            maxHeap[index] = temp;
                            index = right;
                        }
                    } else {
                        break;
                    }
                }
                return removeElement;
            }
        }

        // 返回「堆」的元素个数
        public int size() {
            return realSize;
        }

        @Override
        public String toString() {
            if (realSize == 0) {
                return "No element!";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                for (int i = 1; i <= realSize; i++) {
                    sb.append(maxHeap[i]);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(']');
                return sb.toString();
            }
        }
    }
}