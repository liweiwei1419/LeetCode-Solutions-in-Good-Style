public class NumArray3 {

    private SegmentTree<Integer> segmentTree;

    public NumArray3(int[] nums) {
        Merger<Integer> merger = new Merger<Integer>() {
            @Override
            public Integer merge(Integer e1, Integer e2) {
                return e1 + e2;
            }
        };
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        segmentTree = new SegmentTree(arr, merger);
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    private interface Merger<E> {
        E merge(E e1, E e2);
    }

    private class SegmentTree<E> {
        private E[] tree;
        private int len;
        private Merger<E> merger;

        private SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            len = arr.length;
            tree = (E[]) new Object[len * 2];
            for (int i = len; i < 2 * len; i++) {
                tree[i] = arr[i - len];
            }
            for (int i = len - 1; i > 0; i--) {
                tree[i] = merger.merge(tree[2 * i], tree[2 * i + 1]);
            }
        }

        public E query(int l, int r) {
            l += len;
            r += len;
            E res = null;
            while (l <= r) {
                if (l % 2 == 1) {
                    if (res == null) {
                        res = tree[l];
                    } else {
                        res = merger.merge(res, tree[l]);
                    }
                    l++;
                }
                if (r % 2 == 0) {
                    if (res == null) {
                        res = tree[r];
                    } else {
                        res = merger.merge(res, tree[r]);
                    }
                    r--;
                }
                l /= 2;
                r /= 2;
            }
            return res;
        }

        public void set(int i, E val) {
            i += len;
            tree[i] = val;
            while (i > 0) {
                int left = i;
                int right = i;
                // i 是左边结点
                if (i % 2 == 0) {
                    right = i + 1;
                } else {
                    left = i - 1;
                }
                if (left == 0) {
                    tree[i / 2] = tree[right];
                } else {
                    tree[i / 2] = merger.merge(tree[left], tree[right]);

                }
                i /= 2;
            }
        }
    }
}
