public class BinarySearchTree {

    /**
     * 根结点
     */
    private Node root;

    /**
     * 二叉搜索树中的结点个数
     */
    private int size;

    /**
     * 默认构造一棵空的二叉搜索树
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        /**
         * 为了方便说明二叉搜索树的设计思想，我们将 key 和 value 设置成 int 类型
         */
        private int key;
        private int value;
        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    /**
     * 向以 node 为结点的二叉搜索树中插入节点（key，value），
     * 将当前 node 的 key 与插入节点的 key 进行比较，进而决定向左子树插入还是右子树插入
     *
     * @param node
     * @param key
     * @param value
     * @return 插入了新的结点的二叉搜索树的根结点
     */
    private Node insert(Node node, int key, int value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key == node.key) {
            // 如果 key 值重复，value 值更新，这一点是人为定义
            node.value = value;
        } else if (key < node.key) {
            // 插入了新的结点的子树是原来结点的左子树
            node.left = insert(node.left, key, value);
        } else {
            // 插入了新的结点的子树是原来结点的右子树
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    /**
     * @param key
     * @return 如果找不到对应的 key，返回 null，因此将返回值设计成 Integer 包装类型
     */
    public Integer search(int key) {
        return search(root, key);
    }

    /**
     * 在以 node 为根的二叉搜索树中查找 key 所对应的 value
     *
     * @param node
     * @param key
     * @return
     */
    private Integer search(Node node, int key) {
        // 先处理递归到底的情况
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node.value;
        } else if (key < node.key) {
            // 在以 node.left 为根结点的子树中继续查找
            return search(node.left, key);
        } else {
            // 在以 node.right 为根结点的子树中继续查找
            return search(node.right, key);
        }
    }

    /**
     * @param key
     * @return 查找二叉搜索树中是否存在 key 等于给定 key 值的结点
     */
    public boolean contains(int key) {
        return contains(root, key);
    }

    private boolean contains(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        } else if (key < node.key) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    /**
     * 查找二叉搜索树 key 的最小值
     *
     * @return
     */
    public int minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("当前二叉搜索树是空树。");
        }
        Node node = minimum(root);
        return node.key;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 查找二叉搜索树 key 的最大值
     *
     * @return
     */
    public int maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("当前二叉搜索树是空树。");
        }
        Node node = maximum(root);
        return node.key;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除二叉搜索树中最小的 key 所在的结点
     */
    public void removeMin() {
        if (root != null) {
            // 注意：有可能删除的结点是根结点，因此
            // 在设计 removeMin 删除方法的时候，需要返回删除了最小 key 以后的新的树的根结点
            root = removeMin(root);
        }
    }

    /**
     * @param node
     * @return 删除了最小 key 的结点以后的树的根结点
     */
    private Node removeMin(Node node) {
        // 从根结点一直向左子树方向走，直到当前结点不存在左子树的时候，当前结点就是整棵树中 key 最小的结点
        if (node.left == null) {
            // 仔细体会这个逻辑，用当前结点的右子树替换当前结点，因此，需要先保存当前结点的右子树
            Node rightNode = node.right;
            // 切断引用，让当前结点成为游离结点，等待垃圾回收机制回收
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二叉搜索树中最大的 key 所在的结点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node nodeLeft = node.left;
            node.left = null;
            size--;
            return nodeLeft;
        }
        node.right = removeMax(node.right);
        return node;
    }


    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = remove(node.left, key);
            return node;
        } else if (key > node.key) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // key == node.key
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 当前 node 的后继
            Node successor = minimum(node.right);
            size++;// 下面删除了一个节点，所以要先加一下
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            size--;
            return successor;
        }
    }

    public Integer floor(int key) {
        return floor(root, key);
    }

    /**
     * @param node
     * @param key
     * @return 返回以 node 为根的二叉搜索树中，小于等于 key 的最大结点的 key
     */
    private Integer floor(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node.key;
        }
        if (key < node.key) {
            return floor(node.left, key);
        }
        Integer temp = floor(node.right, key);
        if (temp != null) {
            return temp;
        }
        return node.key;
    }

    public Integer ceiling(int key) {
        return ceiling(key);
    }

    /**
     * @param node
     * @param key
     * @return 返回以 node 为根的二叉搜索树中，大于等于 key 的最小结点的 key
     */
    private Integer ceiling(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node.key;
        }
        if (key > node.key) {
            return ceiling(node.right, key);
        }
        Integer temp = ceiling(node.left, key);
        if (temp != null) {
            return temp;
        }
        return node.key;
    }
}