class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
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

        left_node = self.sortList(head)
        right_node = self.sortList(new_head)
        return self.__merge_two_sorted_list(left_node, right_node)

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
