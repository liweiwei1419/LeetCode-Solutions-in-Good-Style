import java.util.Comparator;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        // Comparator.comparingInt(o -> o.val) 这样写表示最小堆
        // Comparator.comparingInt(o -> -o.val) 这样写表示最大堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (!minHeap.isEmpty()) {
            // 先看一眼，并不取出
            ListNode top = minHeap.peek();
            curNode.next = top;
            curNode = curNode.next;

            if (top.next == null) {
                // 只有在当前结点是链表的最后一个结点的时候，才取出
                minHeap.poll();
            } else {
                // 否则执行 replace 操作
                minHeap.replace(top.next);
            }
        }
        return dummyNode.next;
    }

    public class PriorityQueue<T> {

        private T[] data;

        private Comparator<T> cmp;

        private int capacity;

        private int size;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆为空。");
            }
            // 下标 0 不存元素
            return data[1];
        }

        public PriorityQueue(int capacity, Comparator<T> cmp) {
            this.cmp = cmp;
            data = (T[]) new Object[capacity + 1];
            this.capacity = capacity;
            size = 0;
        }

        public void offer(T item) {
            if (size + 1 > capacity) {
                throw new IllegalArgumentException("堆空间已满。");
            }

            // 把新添加的元素放在数组的最后一位
            data[size + 1] = item;
            // 维护 size 的定义
            size++;
            // 考虑将 data[size] 元素上移到合适的位置
            siftUp(size);
        }

        private void swap(T[] data, int index1, int index2) {
            T temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

        private void siftUp(int k) {
            T temp = data[k];
            while (k > 1) {
                if (cmp.compare(data[k / 2], temp) > 0) {
                    data[k] = data[k / 2];
                    k /= 2;
                } else {
                    break;
                }
            }
            data[k] = temp;
        }

        public T poll() {
            if (size == 0) {
                throw new IllegalArgumentException("堆为空。");
            }
            T ret = data[1];
            // 把最后一个元素的值赋值到二叉堆的根结点
            data[1] = data[size];
            size--;
            siftDown(1);
            return ret;
        }

        private void siftDown(int k) {
            // 编写方式等价于「插入排序」的优化，先暂存，再逐个移动，最后空出位置把先前暂存元素放进去
            T temp = data[k];
            while (2 * k <= size) {
                int j = 2 * k;
                if (j + 1 <= size && cmp.compare(data[j + 1], data[j]) < 0) {
                    j++;
                }
                if (cmp.compare(temp, data[j]) <= 0) {
                    break;
                }
                data[k] = data[j];
                k = j;
            }
            data[k] = temp;
        }

        public void replace(T item) {
            if (isEmpty()) {
                throw new IllegalArgumentException("堆为空。");
            }
            // 注意：堆顶元素替换，size 不变
            data[1] = item;
            siftDown(1);
        }
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        Solution solution = new Solution();
        ListNode mergeKLists = solution.mergeKLists(lists);
        System.out.println(mergeKLists);
    }
}
