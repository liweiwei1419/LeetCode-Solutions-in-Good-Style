public class MyLinkedList2 {

    class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] nums) {
            this.val = nums[0];
            ListNode curNode = this;
            for (int i = 1; i < nums.length; i++) {
                curNode.next = new ListNode(nums[i]);
                curNode = curNode.next;
            }
        }

        @Override
        public String toString() {
            ListNode curNode = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (curNode != null) {
                stringBuilder.append(curNode.val);
                stringBuilder.append(" -> ");
                curNode = curNode.next;
            }
            stringBuilder.append("NULL");
            return stringBuilder.toString();
        }
    }

    /**
     * 设计虚拟头结点是普遍的做法
     */
    private ListNode dummyHead;
    /**
     * 设计尾指针是为了方便在尾部操作
     */
    private ListNode dummyTail;

    /**
     * 为了保证用户输入的 index 合法，故维护链表的长度
     */
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        size = 0;
        dummyHead = new ListNode(-1);
        dummyTail = new ListNode(-1);

        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        // 与单链表设计无差别
        if (index < 0 || index >= size) {
            // throw new IllegalArgumentException("您输入的 index 不合法");
            return -1;
        }

        ListNode curNode = dummyHead;
        for (int i = 0; i < index + 1; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        ListNode nextNode = dummyHead.next;
        // 顺序：dummyHead -> newNode -> nextNode

        dummyHead.next = newNode;

        // 维护 newNode
        newNode.pre = dummyHead;
        newNode.next = nextNode;

        nextNode.pre = newNode;

        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        // 顺序 preNode -> newNode -> dummyTail
        ListNode preNode = dummyTail.pre;
        preNode.next = newNode;

        newNode.pre = preNode;
        newNode.next = dummyTail;

        dummyTail.pre = newNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            // throw new IllegalArgumentException("您输入的 index 不合法");
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            // 注意 size 表示的是下一个待添加到末尾元素的位置
            addAtTail(val);
            return;
        }


        ListNode preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        ListNode newNode = new ListNode(val);

        // 先保存下一个结点的引用
        // 顺序：pre -> newNode -> nextNode
        ListNode nextNode = preNode.next;

        nextNode.pre = newNode;
        preNode.next = newNode;

        newNode.pre = preNode;
        newNode.next = nextNode;

        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        // 如果是单链表，这个操作比较复杂，时间复杂度是 O(N)
        if (index < 0 || index >= size) {
            // throw new IllegalArgumentException("您输入的 index 不合法");
            return;
        }

        ListNode preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        // 顺序：
        // preNode deleteNode nextNode

        ListNode deleteNode = preNode.next;
        ListNode nextNode = deleteNode.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;

        deleteNode.pre = null;
        deleteNode.next = null;

        size--;
    }
}
