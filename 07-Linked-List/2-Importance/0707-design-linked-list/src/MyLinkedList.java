public class MyLinkedList {

    class ListNode {
        int val;
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
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(-1);
        dummyTail = new ListNode(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

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
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;

        // 注意维护尾指针
        if (size == 0){
            dummyTail.next = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        dummyTail.next.next = newNode;
        dummyTail.next = newNode;

//        ListNode tailNode = dummyTail.next;
//        tailNode.next = newNode;
//        dummyTail = newNode;


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

        ListNode newNode = new ListNode(val);

        ListNode preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        // 先保存一下下一个结点的引用
        ListNode nextNode = preNode.next;
        preNode.next = newNode;
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

        ListNode curNode = dummyHead;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        ListNode deleteNode = curNode.next;
        curNode.next = deleteNode.next;
        deleteNode.next = null;

        // 注意维护 tail 指针
        if (index == size - 1) {
            dummyTail.next = curNode;
        }

        size--;
    }
}