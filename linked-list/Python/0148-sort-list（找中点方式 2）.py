class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 不符合常数级空间复杂度的要求，但是这是一般方法，要求掌握

    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        # 找到中点
        slow = head
        fast = head
        # 使用这种方式，当结点个数为 2 个时候，slow 在左结点
        # 不会导致死循环
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        head2 = slow.next
        # 记得切断链接
        slow.next = None

        left_node = self.sortList(head)
        right_node = self.sortList(head2)

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
