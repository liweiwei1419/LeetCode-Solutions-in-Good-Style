# 74. 搜索二维矩阵
# 直接在矩阵上使用二分查找
# 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
#
# 每行中的整数从左到右按升序排列。
# 每行的第一个整数大于前一行的最后一个整数。


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        # [[]] 针对这种情况，要特判
        if n == 0:
            return False

        l = 0
        r = m * n - 1

        while l < r:
            mid = l + (r - l) // 2
            if matrix[mid // n][mid % n] < target:
                l = mid + 1
            else:
                r = mid
        return matrix[l // n][l % n] == target


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
