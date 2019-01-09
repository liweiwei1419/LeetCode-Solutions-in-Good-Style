# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    # If there is no cycle, return null.

    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        if head is None:
            return None

        slow = head
        fast = head

        while fast:
            fast = fast.next
            if fast:
                fast = fast.next
                slow = slow.next
            else:
                return None
            if fast == slow:
                break

        # 走到这里有两种情况，都要判断
        if fast:
            # 此时 fast == slow 为 True
            point = head
            while slow != point:
                slow = slow.next
                point = point.next
            return point
        else:
            return None


