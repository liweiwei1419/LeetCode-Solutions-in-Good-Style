from typing import List


# 来自：官方题解（暂未理解）

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # init first combination
        nums = list(range(1, k + 1)) + [n + 1]
        # print(nums)

        output, j = [], 0
        while j < k:
            # add current combination
            output.append(nums[:k])
            # increase first nums[j] by one
            # if nums[j] + 1 != nums[j + 1]
            j = 0
            while j < k and nums[j + 1] == nums[j] + 1:
                nums[j] = j + 1
                j += 1
                print(nums)
            nums[j] += 1
            # print(nums)

        return output


if __name__ == '__main__':
    solution = Solution()
    n = 4
    k = 2
    res = solution.combine(n, k)
    print(res)
