# 130. 被围绕的区域
# 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
# 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
# https://segmentfault.com/a/1190000012898131


class Solution:
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        global m, n, directions
        m = len(board)
        if m == 0:
            return
        n = len(board[0])
        directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

        for row_index in range(m):
            self.__flood_fill(board, row_index, 0)
            self.__flood_fill(board, row_index, n - 1)
        for col_index in range(1, n - 1):
            self.__flood_fill(board, 0, col_index)
            self.__flood_fill(board, m - 1, col_index)

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '-':
                    board[i][j] = 'O'

    def __flood_fill(self, board, x, y):
        if 0 <= x < m and 0 <= y < n and board[x][y] == 'O':
            board[x][y] = '-'
            for direction in directions:
                new_x = x + direction[0]
                new_y = y + direction[1]
                self.__flood_fill(board, new_x, new_y)


if __name__ == '__main__':
    # board = [['X', 'X', 'X', 'X'],
    #          ['X', 'O', 'O', 'X'],
    #          ['X', 'X', 'O', 'X'],
    #          ['X', 'O', 'X', 'X']]
    board = [['O', 'O', 'O'],
             ['O', 'O', 'O'],
             ['O', 'O', 'O']]

    # board = [["X", "O", "X", "O", "X", "O"],
    #          ["O", "X", "O", "X", "O", "X"],
    #          ["X", "O", "X", "O", "X", "O"],
    #          ["O", "X", "O", "X", "O", "X"]]
    solution = Solution()
    solution.solve(board)
    for row in board:
        print(row)
