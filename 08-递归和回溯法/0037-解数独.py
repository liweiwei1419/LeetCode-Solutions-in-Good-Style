import time
import sys


# 虽然成功了，但是已经超时！！！

# 37. 解数独
# 编写一个程序，通过已填充的空格来解决数独问题。
#
# 一个数独的解法需遵循如下规则：
#
# 数字 1-9 在每一行只能出现一次。
# 数字 1-9 在每一列只能出现一次。
# 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
# 空白格用 '.' 表示。
class Solution:

    def __print(self, board):
        result = ''
        # i 表示行，是纵坐标，要特别注意
        for i in range(9):
            # j 表示列，是横坐标，要特别注意
            for j in range(9):
                if board[i][j] == '.':
                    result += ' '
                else:
                    result += board[i][j]
                result += ' '
            result += '\n'
        return result

    def check(self, board, x, y):
        # x 表示横坐标，y 表示纵坐标
        num = board[x][y]
        # 水平方向上，已经出现的数
        h_nums = [board[x][col_index] for col_index in range(9) if col_index != y and board[x][col_index] != '.']
        # 判断
        if num in h_nums:
            return False
        # print('h_nums', h_nums)

        # 垂直方向方向上，已经出现的数
        v_nums = [board[row_index][y] for row_index in range(9) if row_index != x and board[row_index][y] != '.']
        # 判断
        if num in v_nums:
            return False
        # print('v_nums', v_nums)

        # 重点理解下面这个变量的定义：所在小正方形左上角的横坐标
        x_left = (x // 3) * 3
        # 重点理解下面这个变量的定义：所在小正方形左上角的纵坐标
        y_up = (y // 3) * 3

        block_nums = []
        for row in range(3):
            for col in range(3):
                if not ((x_left + row) == x and (y_up + col) == y):
                    if board[x_left + row][y_up + col] != 0:
                        block_nums.append(board[x_left + row][y_up + col])

        # print('block_nums', block_nums)

        if num in block_nums:
            return False
        # 以上 3 个条件都判断完以后，才能把 val 放在坐标 (x,y) 处
        return True

    def next(self, board):
        # i 表示每一行
        for i in range(9):
            # j 表示每一列
            for j in range(9):
                if board[i][j] == '.':
                    return i, j
        # 表示没有下一个元素了，数独任务完成
        return False

    def __accept(self, board):
        # 如果没有了，就表示填完，返回 True
        if self.next(board) is False:
            return True
        # 否则就表示数独任务没有完成
        return False

    def __solve(self, board):
        # time.sleep(0.1)
        # print(board)
        # sys.stdout.flush()

        # 先写递归终止条件
        if self.__accept(board):
            return True
        x, y = self.next(board)
        for i in range(1, 10):
            board[x][y] = str(i)
            if self.check(board, x, y) and self.__solve(board):
                return True
            board[x][y] = '.'
        return False

    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.__solve(board)


if __name__ == '__main__':
    board = [['5', '3', '.', '.', '7', '.', '.', '.', '.'],
             ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
             ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
             ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
             ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
             ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
             ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
             ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
             ['.', '.', '.', '.', '8', '.', '.', '7', '9']]
    solution = Solution()
    solution.solveSudoku(board)

    for row in board:
        print(row)
