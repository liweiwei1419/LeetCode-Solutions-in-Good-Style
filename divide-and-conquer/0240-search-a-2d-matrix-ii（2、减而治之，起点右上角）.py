class Solution:
    def searchMatrix(self, matrix, target):
        # 特判
        rows = len(matrix)
        if rows == 0:
            return False

        cols = len(matrix[0])
        if cols == 0:
            return False

        # 起点：右上
        x = 0
        y = cols -1

        # 不越界的条件是：行小于等于 rows - 1，列大于等于 0
        while x < rows and y >= 0:
            if matrix[x][y] > target:
                y -= 1
            elif matrix[x][y] < target:
                x += 1
            else:
                return True
        return False
