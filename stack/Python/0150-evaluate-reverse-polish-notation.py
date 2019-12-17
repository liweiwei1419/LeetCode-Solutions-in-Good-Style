from typing import List


class Solution:

    # 其实是一个很简单的问题，读到数字的时候入栈，读到符号的时候出栈

    def evalRPN(self, tokens: List[str]) -> int:
        size = len(tokens)
        if size == 0:
            return 0
        stack = []
        c = 0
        operators = "+-*/"
        for i in range(size):
            cur = tokens[i]
            if cur in operators:
                a = stack.pop()
                b = stack.pop()

                if '+' == cur:
                    c = b + a

                if '-' == cur:
                    c = b - a

                if '*' == cur:
                    c = b * a

                if '/' == cur:
                    # 这里要特别小心
                    c = int(b / a)
                stack.append(c)
            else:
                stack.append(int(cur))
        return stack.pop()


if __name__ == '__main__':

    tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    solution = Solution()

    res = solution.evalRPN(tokens)
    print(res)
