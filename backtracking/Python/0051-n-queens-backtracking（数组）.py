from typing import List


class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        if n == 0:
            return res

        nums = [i for i in range(n)]
        col = [False for _ in range(n)]
        master = [False for _ in range(2 * n - 1)]
        slave = [False for _ in range(2 * n - 1)]
        stack = []

        self.__backtracking(nums, 0, n, col, master, slave, stack, res)
        return res

    def __backtracking(self, nums, row, n, col, master, slave, stack, res):
        if row == n:
            board = self.__convert2board(stack, n)
            res.append(board)
            return

        for i in range(n):
            if not col[i] and not master[row + i] and not slave[row - i + n - 1]:
                stack.append(nums[i])
                col[i] = True
                master[row + i] = True
                slave[row - i + n - 1] = True

                self.__backtracking(nums, row + 1, n, col, master, slave, stack, res)

                slave[row - i + n - 1] = False
                master[row + i] = False
                col[i] = False
                stack.pop()

    def __convert2board(self, stack, n):
        return ["." * stack[i] + "Q" + "." * (n - stack[i] - 1) for i in range(n)]


if __name__ == '__main__':
    n = 4
    solution = Solution()
    res = solution.solveNQueens(n)
    print(res)
