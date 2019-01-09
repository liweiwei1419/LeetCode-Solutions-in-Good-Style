# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def create_linked_list(nums):
    if len(nums) == 0:
        return None
    head = ListNode(nums[0])
    cur = head
    for i in range(1, len(nums)):
        cur.next = ListNode(nums[i])
        cur = cur.next
    return head


def print_linked_list(list_node):
    if list_node is None:
        return

    cur = list_node
    while cur:
        print(cur.val, '->', end=' ')
        cur = cur.next
    print('null')


class Solution:
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        if head is None:
            return None
        dummy_node = ListNode(-1)
        dummy_node.next = head
        pre = dummy_node
        cur = head
        while cur:
            if cur.val == val:
                pre.next = cur.next
                cur.next = None
                cur = pre.next
            else:
                pre = cur
                cur = cur.next
        return dummy_node.next


if __name__ == '__main__':
    nums = [1, 2, 6, 3, 4, 5, 6]
    head = create_linked_list(nums)
    val = 6
    print_linked_list(head)
    s = Solution()
    result = s.removeElements(head, val)
    print('结果：')
    print_linked_list(result)
