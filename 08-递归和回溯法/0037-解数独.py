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
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
