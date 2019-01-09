# 关键：从右上角或者左下角开始找
# https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66139/6-9-lines-C++Python-Solutions-with-Explanations


class Solution(object):

    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row_num = len(matrix)
        if row_num == 0:
            return False
        col_num = len(matrix[0])
        # 从右上角开始找
        x = 0
        y = col_num - 1
        while x < row_num and y >= 0:
            if matrix[x][y] == target:
                return True
            if matrix[x][y] > target:
                y -= 1
            else:
                x += 1
        return False


if __name__ == '__main__':
    matrix = [[1, 4, 7, 11, 15],
              [2, 5, 8, 12, 19],
              [3, 6, 9, 16, 22],
              [10, 13, 14, 17, 24],
              [18, 21, 23, 26, 30]]
    target = 5
    solution = Solution()
    result = solution.searchMatrix(matrix, target)
    print(result)
