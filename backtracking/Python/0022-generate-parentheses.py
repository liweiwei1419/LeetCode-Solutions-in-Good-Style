from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        def dfs(left, right, s):
            if right == 0:
                res.append(s)
                return

            if left > 0:
                dfs(left - 1, right, s + "(")
            if right > left:
                dfs(left, right - 1, s + ")")

        res = []

        left = n
        right = n

        dfs(left, right, "")
        return res
