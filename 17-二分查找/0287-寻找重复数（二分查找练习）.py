from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        l = 1
        r = size - 1

        while l < r:
            mid = l + (r - l) // 2

            counter = 0
            for num in nums:
                if num <= mid:
                    counter += 1

            # 【注意】如果小于等于 mid 的个数如果多于 mid，例如：
            # 8 个萝卜 放在 7 个坑里，就至少有 1 个坑里至少有 2 个萝卜
            # 这个坑的位置可能是 1、2、3、4、5、6、7
            # 重复的数就一定在 [1, mid] 里面，包括 1 和 mid
            # 此时，不排除中位数的分支逻辑好想，因此写在前面

            if counter > mid:
                r = mid
            else:
                # 我认为这个逻辑太难想了，但我知道这样写一定对
                l = mid + 1

        return l
