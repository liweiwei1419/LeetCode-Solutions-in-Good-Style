from typing import List
import heapq


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        l = []
        size = len(lists)

        for index in range(size):
            # 针对一些特殊的测试用例，有的链表可能是空链表
            if lists[index]:
                heapq.heappush(l, (lists[index].val, index))

        dummy_node = ListNode(-1)
        cur = dummy_node

        while l:
            _, index = heapq.heappop(l)

            # 定位到此时应该出列的那个链表的头结点
            head = lists[index]
            # 开始“穿针引线”
            cur.next = head
            cur = cur.next
            # 同样不要忘记判断到链表末尾结点的时候
            if head.next:
                # 刚刚出列的那个链表的下一个结点成为新的链表头结点加入优先队列
                heapq.heappush(l, (head.next.val, index))
                # 切断刚刚出列的那个链表的头结点引用
                lists[index] = head.next
                head.next = None
        return dummy_node.next
