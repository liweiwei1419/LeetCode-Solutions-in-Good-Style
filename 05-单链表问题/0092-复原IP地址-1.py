# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        dummy_node = ListNode(-1)
        dummy_node.next = head
        cur_node = dummy_node
        for _ in range(m - 1):
            cur_node = cur_node.next
        begin = cur_node
        end = cur_node.next
        # 向前走一步
        cur_node = cur_node.next
        # 再前走一步
        pre = cur_node
        cur_node = cur_node.next
        for _ in range(n - m):
            next = cur_node.next
            cur_node.next = pre
            pre = cur_node
            cur_node = next
        begin.next = pre
        end.next = cur_node
        return dummy_node.next


if __name__ == '__main__':

    def createLinkedList(nums):
        head = ListNode(nums[0])
        cur = head
        for i in range(1, len(nums)):
            cur.next = ListNode(nums[i])
            cur = cur.next
        return head


    def printLinkedList(head):
        while head:
            print('{} -> '.format(head.val), end='')
            head = head.next
        print('NULL')


    head = createLinkedList([1, 2, 3, 4, 5])
    printLinkedList(head)
    solution = Solution()
    m = 2
    n = 4
    result = solution.reverseBetween(head, m, n)
    printLinkedList(result)
