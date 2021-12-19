import java.util.NoSuchElementException;

// 参考网址：https://algs4.cs.princeton.edu/32bst/BST.java.html

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K k;
        private V val;
        private Node left;
        private Node right;
        /**
         * 以当前结点为根结点的子树的结点数
         * 用于 select 和 rank 方法
         */
        private int size;

        public Node(K k, V val, int size) {
            this.k = k;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    public boolean contains(K k) {
        if (k == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(k) != null;
    }

    /**
     * 根据 key 返回对应的 value，如果 key 找不到，返回 null
     *
     * @param k
     * @return
     */
    public V get(K k) {
        return get(root, k);
    }

    private V get(Node x, K k) {
        if (k == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = k.compareTo(x.k);
        if (cmp < 0) {
            return get(x.left, k);
        } else if (cmp > 0) {
            return get(x.right, k);
        } else {
            return x.val;
        }
    }

    public void put(K k, V val) {
        if (k == null) {
            throw new IllegalArgumentException("calls put() with a null key");
        }
        if (val == null) {
            delete(k);
            return;
        }
        root = put(root, k, val);
    }

    /**
     * @param x
     * @param k
     * @param val
     * @return 注意：这个方法里返回以 x 为根结点的新的二分搜索树的根结点
     */
    private Node put(Node x, K k, V val) {
        if (x == null) {
            return new Node(k, val, 1);
        }
        int cmp = k.compareTo(x.k);
        if (cmp < 0) {
            x.left = put(x.left, k, val);
        } else if (cmp > 0) {
            x.right = put(x.right, k, val);
        } else {
            x.val = val;
        }

        // 添加了一个键值对以后，维护 size 的定义
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * 删除整个二分搜索树中 key 最小的结点
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMin(root);
    }


    private Node deleteMin(Node x) {
        // 真正逻辑在这里，一直向左走，左子树为空的结点是 key 最小的结点，
        // 让它的右子树代替自己，即删除了这个结点
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        // 和 deleteMin 方法一样理解
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K k) {
        if (k == null) {
            throw new IllegalArgumentException("calls delete() with a null key");
        }
        root = delete(root, k);
    }

    private Node delete(Node x, K k) {
        if (x == null) {
            return null;
        }

        int cmp = k.compareTo(x.k);
        if (cmp < 0) {
            x.left = delete(x.left, k);
        } else if (cmp > 0) {
            x.right = delete(x.right, k);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }

            // 即有左子树又有右子树的情况，这里使用右子树中的最小结点（后继结点）代替自己
            Node temp = x;
            // 将右子树中最小的结点代替自己
            x = min(temp.right);
            // 重新定义 x 的左右子树
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        // 维护 size 的定义
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * @return 返回二分搜索树中最小的 key
     */
    public K min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).k;
    }

    private Node min(Node x) {
        // 这个逻辑很重要，一直向左走，直到没有左结点，自己就是 key 最小的结点
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    public K max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).k;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }


    public K floor(K k) {
        if (k == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        if (isEmpty()) {
            // throw new NoSuchElementException("calls floor() with empty symbol table");
            return null;
        }
        Node x = floor(root, k);
        if (x == null) {
            // throw new NoSuchElementException("argument to floor() is too small");
            return null;
        } else {
            return x.k;
        }
    }

    /**
     * 在以 x 为根的二叉搜索树中，查找 k 的 地板（小于 k 的最大 key 所在的 Node）
     *
     * @param x
     * @param k
     * @return
     */
    private Node floor(Node x, K k) {
        if (x == null) {
            return null;
        }
        int cmp = k.compareTo(x.k);
        // 规定：如果等于 k，返回当前结点
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, k);
        }

        // 此时 cmp > 0，即 k > x.k
        // 难点：来到小于 k 的结点，向右找，找到就将自己返回，这里如果不太好理解的话，可以画图，用具体例子帮助理解
        Node temp = floor(x.right, k);
        if (temp != null) {
            return temp;
        } else {
            return x;
        }
    }

    public K ceiling(K k) {
        if (k == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        if (isEmpty()) {
            // throw new NoSuchElementException("calls ceiling() with empty symbol table");
            return null;
        }
        Node x = ceiling(root, k);
        if (x == null) {
//                throw new NoSuchElementException("argument to ceiling() is too large");
            return null;
        } else {
            return x.k;
        }
    }

    private Node ceiling(Node x, K k) {
        if (x == null) {
            return null;
        }
        int cmp = k.compareTo(x.k);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node temp = ceiling(x.left, k);
            if (temp != null) {
                return temp;
            } else {
                return x;
            }
        }
        return ceiling(x.right, k);
    }

    /**
     * @param rank
     * @return 返回排名为 rank 的结点的 key（减治思想）
     */
    public K select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    private K select(Node x, int rank) {
        if (x == null) {
            return null;
        }
        int leftSize = size(x.left);
        if (leftSize > rank) {
            return select(x.left, rank);
        } else if (leftSize < rank) {
            // 如果左子树的结点数量 < 排名，说明需要在当前右子树中查找，这里减 1 是减去当前结点
            return select(x.right, rank - leftSize - 1);
        } else {
            return x.k;
        }
    }

    /**
     * @param k
     * @return 返回 k 的排名（rank）
     */
    public int rank(K k) {
        if (k == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        return rank(k, root);
    }

    private int rank(K k, Node x) {
        // 先找到 k，找不到，返回 0
        if (x == null) {
            return 0;
        }
        int cmp = k.compareTo(x.k);
        if (cmp < 0) {
            // 如果当前 key = 8，要找的 k 的 6，应该继续向左边查找
            return rank(k, x.left);
        } else if (cmp > 0) {
            // 如果当前 key = 3，要找的 k 的 6，应该继续向左边查找
            // 1 是当前 key，
            // rank(k, x.right) 表示在右子树中 k 的排名
            return 1 + size(x.left) + rank(k, x.right);
        } else {
            // 此时找到了 k
            // 真正逻辑：左边结点的个数就是以 x 为根结点的子树中，x 的排名
            return size(x.left);
        }
    }
}