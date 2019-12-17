class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 分治法

    def sortedListToBST(self, head: ListNode) -> TreeNode:
        # 特判：当结点为空，或者单结点的时候的简单逻辑
        if head is None:
            return None

        if head.next is None:
            return TreeNode(head.val)

        # 设置 pre 指针是为了切断单链表 mid 的前半部分
        pre = None
        slow = head
        fast = head

        # 如果写 while fast and fast.next: 后面的代码稍有不同
        while fast.next and fast.next.next:
            pre = slow
            slow = slow.next
            fast = fast.next.next

        # 此时 slow 结点就位于链表的中部，它的值就作为 BST 的根结点返回
        root = TreeNode(slow.val)

        # 因为要传入下一个递归方法，所以得先保存索引
        new_head = slow.next
        slow.next = None

        # 当链表只有 2 个结点的时候，pre 指针此时为 None，不用递归构造左子树
        if pre:
            pre.next = None
            root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(new_head)
        return root
