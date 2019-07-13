class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# 思想：快慢指针（推荐）

class Solution(object):

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return False

        slow = head
        # 快指针先走一步
        fast = head.next
        while slow != fast:
            if fast is None or fast.next is None:
                return False
            slow = slow.next
            fast = fast.next.next
        return True