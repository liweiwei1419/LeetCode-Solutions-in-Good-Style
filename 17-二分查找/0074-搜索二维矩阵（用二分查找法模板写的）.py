# 74. 搜索二维矩阵
# 直接在矩阵上使用二分查找
# 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
#
# 每行中的整数从左到右按升序排列。
# 每行的第一个整数大于前一行的最后一个整数。

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # [[]] 针对这种情况，要特判
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        if n == 0:
            return False

        left = 0
        right = m * n - 1

        while left < right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1

            if matrix[mid // n][mid % n] < target:
                left = mid + 1
            else:
                right = mid
        # 后处理
        return matrix[left // n][left % n] == target


if __name__ == '__main__':
    # matrix = [
    #     [1, 3, 5, 7],
    #     [10, 11, 16, 20],
    #     [23, 30, 34, 50]
    # ]
    # target = 3
    #
    # solution = Solution()
    # result = solution.searchMatrix(matrix, target)
    # print(result)

    matrix = [
        [1]
    ]

    solution = Solution()
    result = solution.searchMatrix(matrix, 2)
    print(result)
