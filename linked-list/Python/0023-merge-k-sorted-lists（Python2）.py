class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    # 优先队列

    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        import heapq
        l = []
        for head in lists:
            if head:
                heapq.heappush(l, (head.val, head))
        dummy_node = ListNode(-1)
        cur = dummy_node

        while l:
            _, head = heapq.heappop(l)
            cur.next = head
            cur = cur.next
            if head.next:
                heapq.heappush(l, (head.next.val, head.next))

        return dummy_node.next
