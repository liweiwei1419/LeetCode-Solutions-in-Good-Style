# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# 这里有个小陷阱，如果遇到问题，不要着急，代码调试就好了

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        # 玄机在这里，如果非要用 while fast and fast.next:
        # 让快指针先走一步，以避免死循环
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        new_head = slow.next
        slow.next = None

        lnode = self.sortList(head)
        rnode = self.sortList(new_head)
        return self.__merge_two_sorted_list(lnode, rnode)

    def __merge_two_sorted_list(self, head1, head2):
        if head1 is None:
            return head2
        if head2 is None:
            return head1

        if head1.val < head2.val:
            head1.next = self.__merge_two_sorted_list(head1.next, head2)
            return head1
        else:
            head2.next = self.__merge_two_sorted_list(head1, head2.next)
            return head2


def create_node_list(arr):
    head = ListNode(arr[0])
    cur = head
    for i in range(1, len(arr)):
        cur.next = ListNode(arr[i])
        cur = cur.next
    return head


def print_node_list(head):
    while head:
        print(head.val, '->', end=' ')
        head = head.next
    print('NULL')


if __name__ == '__main__':
    arr = [4, 2, 1, 3]
    head = create_node_list(arr)
    print_node_list(head)

    solution = Solution()
    result = solution.sortList(head)
    print_node_list(result)
