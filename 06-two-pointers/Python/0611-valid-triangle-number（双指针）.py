from typing import List


# 根据能够组成三角形的条件
# 1、两边之和大于第 3 边：这里第 3 边一定是最长边（只要满足这一条就可以了）
# 2、两边之差小于第 3 边：这里第 3 边是中间那条边，因为头尾相减差距最大

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        size = len(nums)
        if size < 2:
            return 0

        # 排序是前提
        nums.sort()
        res = 0

        # 外层循环先固定住 k，即先固定终点，然后双指针移动
        for k in range(size - 1, 1, -1):
            i = 0
            j = k - 1

            # 内层循环使用双指针：先固定 j，然后让 i 慢慢大起来，
            # 找到了一个 j 以后，就能得到"一票解"（一系列的解）
            # 找到了一个 j 以后，j 再减少 1，如此反复
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    # 这一步比较关键，类似的题目有三数之和
                    res += (j - i)
                    j -= 1
                else:
                    i += 1
        return res


if __name__ == '__main__':
    nums = [2, 2, 3, 4]
    solution = Solution()
    res = solution.triangleNumber(nums)
    print(res)
