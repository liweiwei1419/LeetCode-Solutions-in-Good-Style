class Solution:
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 1
        right = len(nums) - 1

        # 特别注意：在二分法取中点的算法中，如果有一条分支，不能排除 mid
        # 在写 while 循环的时候，就不能把 = 写进去，否则会出现死循环，
        # 这一点要特别注意

        # 注意，千万不能写 while left <= right，会进入死循环
        # 因为下面有一个分支是 right = mid
        while left < right:
            # 因为在循环过程中，右边界可能不变，就要使用左偏中点
            # [1,2] 时，
            mid = left + (right - left) // 2
            count = 0
            for num in nums:
                if num <= mid:
                    count += 1
            if count <= mid:
                # 在 [left,mid] 这个区间没有重复元素
                # 所以搜索范围在 [mid+1,right]
                left = mid + 1
            else:
                # 在 [left,mid] 这个区间有重复元素
                # 所以搜索范围在 [left,mid]
                right = mid
        # 退出循环的时候 start == end 为 True
        return left


if __name__ == '__main__':
    nums = [1, 3, 4, 2, 2]
    solution = Solution()
    result = solution.findDuplicate(nums)
    print(result)
