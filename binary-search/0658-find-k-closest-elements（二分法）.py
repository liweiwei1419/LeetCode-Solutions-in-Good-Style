from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        size = len(arr)
        left = 0
        right = size - k

        while left < right:
            mid = (left + right) >> 1
            # 尝试从长度为 k + 1 的连续子区间删除一个元素
            # 从而定位左区间端点的边界值
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = -1
    solution = Solution()
    res = solution.findClosestElements(arr, k, x)
    print(res)
