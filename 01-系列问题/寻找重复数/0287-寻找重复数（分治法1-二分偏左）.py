class Solution:
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        start = 1

        end = len(nums) - 1

        while start < end:
            print(start, end)

            # 因为在循环过程中，右边界可能不变，就要使用左偏中点
            # [1,2] 时，
            mid = start + (end - start) // 2
            count = 0
            for num in nums:
                if num <= mid:
                    count += 1

            if count <= mid:
                # 在 [left,mid] 这个区间没有重复元素
                # 所以搜索范围在 [mid+1,right]
                start = mid + 1
            else:
                # 在 [left,mid] 这个区间有重复元素
                # 所以搜索范围在 [left,mid]
                end = mid
        # 退出循环的时候 start == end 为 True
        return start


if __name__ == '__main__':
    nums = [1, 3, 4, 2, 2]
    solution = Solution()
    result = solution.findDuplicate(nums)
    print(result)
