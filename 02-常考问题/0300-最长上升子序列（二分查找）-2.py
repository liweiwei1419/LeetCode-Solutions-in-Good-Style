class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        # 特判
        if size < 2:
            return size

        # 为了防止后序逻辑发生数组索引越界，先把第 1 个数放进去
        tail = [nums[0]]
        for num in nums[1:]:

            # 先尝试是否可以接在末尾
            if num > tail[-1]:
                tail.append(num)
                continue

            # 在有序数组 tail 中找到大于等于 num 的第 1 个数，试图让它变小
            l = 0
            r = len(tail) - 1
            while l < r:
                mid = l + (r - l) // 2
                if tail[mid] < num:
                    l = mid + 1
                else:
                    r = mid
            tail[l] = num

        return len(tail)

    def binary_search_1(l, r):
        # 当分支逻辑不能排除右边界的时候选择左中位数
        # 如果选择右中位数，当区间只剩下 2 个元素的时候，
        # 一旦进入 r = mid 这个分支，右边界不会收缩，代码进入死循环
        while l < r:
            mid = l + (r - l) // 2
            if check(mid):
                # 先写可以排除中位数的逻辑
                l = mid + 1
            else:
                r = mid

    def binary_search_2(l, r):
        # 当分支逻辑不能排除左边界的时候选择右中位数
        # 如果选择做中位数，当区间只剩下 2 个元素的时候，
        # 一旦进入 l = mid 这个分支，左边界不会收缩，代码进入死循环
        while l < r:
            mid = l + (r - l + 1) // 2
            if check(mid):
                # 先写可以排除中位数的逻辑
                r = mid - 1
            else:
                l = mid
