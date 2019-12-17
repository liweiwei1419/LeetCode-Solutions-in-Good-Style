class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head

            # odd 奇数
        odd_head = head
        even_head = head.next

        odd_cur = odd_head
        even_cur = even_head

        while even_cur and even_cur.next:
            odd_cur.next = odd_cur.next.next
            even_cur.next = even_cur.next.next

            odd_cur = odd_cur.next
            even_cur = even_cur.next

        odd_cur.next = even_head
        return odd_head
