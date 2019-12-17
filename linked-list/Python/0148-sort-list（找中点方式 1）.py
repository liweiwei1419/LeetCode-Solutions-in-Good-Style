class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 这里有个小陷阱，如果遇到问题，不要着急，代码调试就好了

    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

        # 找到中点
        slow = head
        fast = head
        while fast and fast.next:
            # 这里要保存一下前一个指针
            p = slow
            slow = slow.next
            fast = fast.next.next
        # 切断链接
        p.next = None
        left_node = self.sortList(head)
        right_node = self.sortList(slow)
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
