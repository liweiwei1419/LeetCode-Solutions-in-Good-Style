class Solution:

    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        # 特判
        if size < 2:
            return size

        tail = []
        for num in nums:
            # 找到大于等于 num 的第 1 个数，试图让它变小
            l = 0
            # 因为有可能 num 比 tail 数组中的最后一个元素还要大，
            # 所以右边界应该设置为 tail 数组的长度
            r = len(tail)
            while l < r:
                mid = l + (r - l) // 2
                if tail[mid] < num:
                    l = mid + 1
                else:
                    r = mid
            if l == len(tail):
                tail.append(num)
            else:
                tail[l] = num
        return len(tail)

