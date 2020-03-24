public class NumArray2 {

    // 线段树的 API 直接写在这个 NumArray 里面

    /**
     * 存放原始数据
     */
    private int[] data;
    /**
     * 存放领导数据
     */
    private int[] tree;

    public NumArray2(int[] nums) {
        // 题目可能传空数组，因此需要特判
        int len = nums.length;
        if (len == 0) {
            return;
        }

        this.data = nums;
        tree = new int[4 * len];
        buildSegmentTree(0, 0, len - 1);
    }

    public int sumRange(int left, int right) {
        if (data.length == 0) {
            return 0;
        }
        return query(left, right);
    }

    private void buildSegmentTree(int node, int left, int right) {
        if (left == right) {
            // data[right]，此时对应叶子结点的情况
            tree[node] = data[left];
            return;
        }
        int mid = (left + right) >>> 1;

        int leftChild = leftChild(node);
        int rightChild = rightChild(node);

        buildSegmentTree(leftChild, left, mid);
        buildSegmentTree(rightChild, mid + 1, right);

        tree[node] = tree[leftChild] + tree[rightChild];
    }

    /**
     * 在一棵子树里做区间查询
     *
     * @param left
     * @param right
     * @return
     */
    public int query(int left, int right) {
        int len = data.length;
        if (left < 0 || right < 0 || right >= len || left > right) {
            throw new IllegalArgumentException("索引越界");
        }
        return query(0, 0, len - 1, left, right);
    }

    /**
     * @param node
     * @param leftNode
     * @param rightNode
     * @param left
     * @param right
     * @return
     */
    private int query(int node, int leftNode, int rightNode, int left, int right) {
        if (leftNode == left && rightNode == right) {
            return tree[node];
        }
        int mid = (leftNode + rightNode) >>> 1;
        int leftChildIndex = leftChild(node);
        int rightChildIndex = rightChild(node);

        if (right <= mid) {
            return query(leftChildIndex, leftNode, mid, left, right);
        }

        if (left >= mid + 1) {
            return query(rightChildIndex, mid + 1, rightNode, left, right);
        }

        int leftSum = query(leftChildIndex, leftNode, mid, left, mid);
        int rightSum = query(rightChildIndex, mid + 1, rightNode, mid + 1, right);
        return leftSum + rightSum;
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        NumArray2 numArray2 = new NumArray2(nums);
        int result = numArray2.sumRange(2, 3);
        System.out.println(result);
    }
}
