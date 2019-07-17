# 关键：从右上角或者左下角开始找
# https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66139/6-9-lines-C++Python-Solutions-with-Explanations


class Solution:
    def searchMatrix(self, matrix, target):
        rows = len(matrix)
        if rows == 0:
            return False
        cols = len(matrix[0])

        col = cols - 1
        row = 0

        # 站在右上角
        while row < rows and col >= 0:

            # print('row', row, 'col', col, array[row][0])
            # 1、现在这一行找，从右到左，找第 1 个小于或者等于 target 的数
            if col == 0 and matrix[row][0] > target:
                return False
            l = 0
            r = col
            while l < r:
                mid = (l + r  + 1) // 2
                if matrix[row][mid] > target:
                    r = mid - 1
                else:
                    l = mid

            if matrix[row][l] == target:
                return True


            # 2、从上到下，找第 1 个大于或者等于 target 的数
            if row == rows - 1 and matrix[rows - 1][col] < target:
                return False

            col = l

            l = row
            r = rows - 1
            while l < r:
                mid = l + (r - l) // 2
                if matrix[mid][col] < target:
                    l = mid + 1
                else:
                    r = mid
            row = l

            if matrix[row][col] == target:
                return True

        return False


if __name__ == '__main__':
    matrix = [[1, 4, 7, 11, 15],
              [2, 5, 8, 12, 19],
              [3, 6, 9, 16, 22],
              [10, 13, 14, 17, 24],
              [18, 21, 23, 26, 30]]
    target = 100
    solution = Solution()
    result = solution.searchMatrix(matrix, target)
    print(result)
