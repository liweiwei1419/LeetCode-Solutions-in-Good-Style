from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # 时间复杂度 O(2n)，空间复杂度 O(1)，res 不算额外空间
        # 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
        # 举个例子：
        # 原始数组：[4, 3, 2, 7, 8, 2, 3, 1]
        # 重置后为：[-4, -3, -2, -7, 8, 2, -3, -1]
        # 结论：[8, 2] 分别对应的 index 为 [5, 6]（消失的数字）
        for num in nums:
            index = abs(num) - 1
            # 始终保持 nums[index] 为负数
            nums[index] = -abs(nums[index])
            # print('调试', nums)
        return [i + 1 for i, num in enumerate(nums) if num > 0]


# 作者：gehui1007
# 链接：https://leetcode-cn.com/problems/two-sum/solution/ti-jie-bu-shi-yong-e-wai-kong-jian-by-gehui1007/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

if __name__ == '__main__':
    solution = Solution()
    nums = [4, 3, 2, 7, 8, 2, 3, 1]
    res = solution.findDisappearedNumbers(nums)
    print(res)
