from typing import List


class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        if n == 0:
            return res

        nums = [i for i in range(n)]
        col = 0
        master = 0
        slave = 0
        stack = []

        self.__backtracking(nums, 0, n, col, master, slave, stack, res)
        return res

    def __backtracking(self, nums, row, n, col, master, slave, stack, res):
        if row == n:
            board = self.__convert2board(stack, n)
            res.append(board)
            return

        for i in range(n):
            if (col >> i) & 1 == 0 \
                    and ((master >> (row + i)) & 1) == 0 \
                    and ((slave >> (row - i + n - 1)) & 1) == 0:
                stack.append(nums[i])
                col ^= (1 << i)
                master ^= (1 << (row + i))
                slave ^= (1 << (row - i + n - 1))

                self.__backtracking(nums, row + 1, n, col, master, slave, stack, res)

                slave ^= (1 << (row - i + n - 1))
                master ^= (1 << (row + i))
                col ^= (1 << i)
                stack.pop()

    def __convert2board(self, stack, n):
        return ["." * stack[i] + "Q" + "." * (n - stack[i] - 1) for i in range(n)]


if __name__ == '__main__':
    n = 4
    solution = Solution()
    res = solution.solveNQueens(n)
    print(res)
