from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # 双指针，减而治之
        size = len(arr)
        left = 0
        right = size - 1

        # 我们要排除掉 size - k 这么多元素
        remove_nums = size - k
        while remove_nums:
            # 调试语句
            # print(left, right, k)
            # 注意：这里等于号的含义，题目中说，差值相等的时候取小的
            # 因此相等的时候，尽量缩小右边界
            if x - arr[left] <= arr[right] - x:
                right -= 1
            else:
                left += 1
            remove_nums -= 1
        return arr[left:left + k]


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = 3
    solution = Solution()
    res = solution.findClosestElements(arr, k, x)
    print(res)
