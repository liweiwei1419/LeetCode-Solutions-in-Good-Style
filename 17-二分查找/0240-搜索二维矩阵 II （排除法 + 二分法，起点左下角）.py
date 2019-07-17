class Solution:

    # 代码有错误，要考虑的边界条件有点复杂，因此不考虑

    def searchMatrix(self, matrix, target):
        # 特判
        rows = len(matrix)
        if rows == 0:
            return False

        cols = len(matrix[0])
        if cols == 0:
            return False

        # 起点：左下角
        x = rows - 1
        y = 0

        # 不越界的条件是：行大于等于 0，列小于等于 cols - 1
        while x >= 0 and y < cols:
            # 打开下面这行注释，调试代码
            print('x:{} y:{}'.format(x, y))

            if matrix[x][y] > target:
                # 极端情况先判断：
                if x == 0 and matrix[0][y] > target:
                    return False

                # 如果大于 target，向上走到第 1 个小于等于 target 的位置，此时列固定
                left = 0  # 表示上
                right = x  # 表示下
                while left < right:
                    mid = (left + right + 1) >> 1
                    if matrix[mid][y] > target:
                        right = mid - 1
                    else:
                        left = mid
                if matrix[left][y] == target:
                    return True
                x = left
            elif matrix[x][y] < target:

                # 极端情况先判断：
                if y == cols - 1 and matrix[x][cols - 1] < target:
                    return False

                # 如果小于 target，向右走到第 1 个大于等于 target 的位置，此时行固定
                left = x
                right = cols - 1

                while left < right:
                    mid = (left + right) >> 1
                    if matrix[mid][y] < target:
                        left = mid + 1
                    else:
                        right = mid
                if matrix[x][left] == target:
                    return True
                y = left
            else:
                return True
        return False


if __name__ == '__main__':
    matrix = [[1, 4, 7, 11, 15],
              [2, 5, 8, 12, 19],
              [3, 6, 9, 16, 22],
              [10, 13, 14, 17, 24],
              [18, 21, 23, 26, 30]]
    target = 12
    solution = Solution()
    result = solution.searchMatrix(matrix, target)
    print(result)
