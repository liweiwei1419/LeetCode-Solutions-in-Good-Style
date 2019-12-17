from typing import List


class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        if n == 0:
            return res

        nums = [i for i in range(n)]
        col = set()
        master = set()
        slave = set()
        stack = []

        self.__backtracking(nums, 0, n, col, master, slave, stack, res)
        return res

    def __backtracking(self, nums, row, n, col, master, slave, stack, res):
        if row == n:
            board = self.__convert2board(stack, n)
            res.append(board)
            return

        for i in range(n):
            if i not in col and row + i not in master and row - i not in slave:
                stack.append(nums[i])
                col.add(i)
                master.add(row + i)
                slave.add(row - i)

                self.__backtracking(nums, row + 1, n, col, master, slave, stack, res)

                slave.remove(row - i)
                master.remove(row + i)
                col.remove(i)
                stack.pop()

    def __convert2board(self, stack, n):
        return ["." * stack[i] + "Q" + "." * (n - stack[i] - 1) for i in range(n)]


if __name__ == '__main__':
    n = 4
    solution = Solution()
    res = solution.solveNQueens(n)
    print(res)
