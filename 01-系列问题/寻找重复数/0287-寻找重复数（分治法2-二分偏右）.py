# 287. 寻找重复数
# 给定一个包含 n + 1 个整数的数组 nums，
# 其数字都在 1 到 n 之间（包括 1 和 n），
# 可知至少存在一个重复的整数。
# 假设只有一个重复的整数，找出这个重复的数。

class Solution:

    def findDuplicate(self, nums):
        """
        【不修改数组找出重复的数字】
        给定一个包含 n + 1 个整数的数组 nums，
        其数字都在 1 到 n 之间（包括 1 和 n），
        可知至少存在一个重复的整数。
        假设只有一个重复的整数，找出这个重复的数。
        :type nums: List[int]
        :rtype: int
        """

        start = 1
        end = len(nums) - 1

        while start < end:
            # 取中点有两种方式，偏左和偏右
            mid = start + (end - start + 1) // 2  # 4
            count = 0
            for num in nums:
                if num < mid:
                    count += 1
            if count < mid:
                # 比 4 小的个数，最多就只能是 3
                # 所以重复的肯定不是 [1,2,3]
                # 因为左边不变，所以取中点的时候，就要偏右
                start = mid
            else:
                # 比 4 小的个数，达到 4 或者更多
                # 重复的就落在 [1,2,3]
                end = mid - 1
        # 跳出循环肯定是因为 start = end
        return start


if __name__ == '__main__':
    nums = [3, 1, 3, 4, 2]
    solution = Solution()
    result = solution.findDuplicate(nums)
    print(result)
