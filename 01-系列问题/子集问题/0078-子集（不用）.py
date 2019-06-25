# 78. 子集
# 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
# 说明：解集不能包含重复的子集。

# 关键词：不含重复元素
# 参考资料：花花酱 https://mp.weixin.qq.com/s/AWuv4p-RQyoCW22DczfTVA
# 参考资料：花花酱 https://mp.weixin.qq.com/s/AWuv4p-RQyoCW22DczfTVA

class Solution:
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []

        def dfs(max_count, begin, path):
            # n 表示当前全排列的个数
            # cur 表示已经拿到的 path
            if max_count == len(path):
                # 够数了，就加到结果集中
                res.append(path.copy())
                return
            for i in range(begin, len(nums)):
                # 加进去表示考虑这个元素
                path.append(nums[i])
                # 注意：这里是 i
                dfs(max_count, i + 1, path)
                # pop() 表示不考虑这个元素
                path.pop()

        for i in range(len(nums) + 1):
            dfs(i, 0, [])
        return res


if __name__ == '__main__':
    nums = [1, 2, 3]
    solution = Solution()
    result = solution.subsets(nums)
    print(result)
