class Solution:
    count = 0

    def totalNQueens(self, n: int) -> int:
        if n == 0:
            return 0

        col = 0
        master = 0
        slave = 0

        self.__backtrack(0, n, col, master, slave)
        return self.count

    def __backtrack(self, row, n, col, master, slave):
        if row == n:
            self.count += 1
            return
        for i in range(n):
            if ((col >> i) & 1 == 0) \
                    and ((master >> (row + i)) & 1 == 0) \
                    and ((slave >> (row - i + n - 1)) & 1 == 0):
                col ^= (1 << i)
                master ^= (1 << (row + i))
                slave ^= (1 << (row - i + n - 1))
                self.__backtrack(row + 1, n, col, master, slave)
                slave ^= (1 << (row - i + n - 1))
                master ^= (1 << (row + i))
                col ^= (1 << i)
