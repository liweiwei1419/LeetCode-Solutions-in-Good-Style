class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        l = len(nums)

        if l <= 2:
            return

        j = 1  # 接下来要覆盖的元素索引
        pre = nums[0]
        cnt = 0  # 重复次数
        for i in range(1, l):
            if nums[i] == pre:
                # 只要有重复，次数就要加 1
                cnt += 1
                # 如果重复次数等于 0
                if cnt == 1:
                    # 同样要覆盖
                    nums[j] = nums[i]
                    j += 1
                # 如果重复次数大于 1
                else:
                    # 这个值不输出到最终结果中，就相当于没有看到这个值
                    continue
            else:
                # 更新 pre，重置次数，覆盖，索引 + 1
                pre = nums[i]
                cnt = 0
                nums[j] = nums[i]
                j += 1
        return j


if __name__ == '__main__':
    nums = [2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5]
    s = Solution()
    result = s.removeDuplicates(nums)

    print(nums[:result])
