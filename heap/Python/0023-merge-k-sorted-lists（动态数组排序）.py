from typing import List


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:

        arr = []

        for list in lists:
            if list is not None:
                cur_node = list
                while cur_node is not None:
                    arr.append(cur_node.val)
                    cur_node = cur_node.next

        arr.sort()

        dummy_node = ListNode(-1)
        cur_node = dummy_node

        size = len(arr)
        for i in range(size):
            cur_node.next = ListNode(arr[i])
            cur_node = cur_node.next

        return dummy_node.next
