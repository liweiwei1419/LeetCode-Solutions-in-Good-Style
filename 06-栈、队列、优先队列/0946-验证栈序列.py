# 946. 验证栈序列
# 给定 pushed 和 popped 两个序列，
# 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，
# 返回 true；否则，返回 false 。


class Solution:
    def validateStackSequences(self, pushed, popped):
        """
        :type pushed: List[int]
        :type popped: List[int]
        :rtype: bool
        """
        if len(pushed) == 0 and len(popped) == 0:
            return False
        if len(pushed) == 0 or len(popped) == 0 or len(pushed) != len(popped):
            return False
        stack = []
        index = 0
        for ele in pushed:
            stack.append(ele)
            while stack and stack[-1] == popped[index]:
                stack.pop()
                index += 1
        return len(stack) == 0
