class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(numbers)

        # 【修改 3】外层循环的最后一个数应该是 length - 2，
        # 这一点也很好想清楚，因为如果第 1 个数就在末尾，第 2 个数的候选区间就为空，没有必要执行查找
        for i in range(length - 1):
            t = target - numbers[i]
            # 【修改 2】初始左边界是 i + 1，
            # 每一次外层循环，固定第 1 个数，在 [i + 1, length - 1] 这个区间里找第 2 个数
            # 这个修改我认为也是必要的，否则很可能会搜索到相同的两个数
            # 不过这道问题的测试用例居然没有覆盖，也是很神奇
            left = i + 1
            right = length - 1

            while left < right:
                mid = (left + right + 1) >> 1
                # 【修改 1】参与比较的数应该是 t，而不是 target，这里应该是您笔误了，t 和 target 一下子没搞清楚

                if numbers[mid] > t:
                    right = mid - 1
                else:
                    left = mid
            if numbers[left] == t:
                return [i + 1, left + 1]
        # 根据题目中的介绍，假设每个输入只对应唯一的答案
        # 因此这里可能抛出一个异常会好一点，表示不是我们编写的算法的问题
        raise ValueError('输入不正确')
        # return []


if __name__ == '__main__':
    numbers = [12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199, 212, 221,
               227, 230,
               277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375, 384, 387, 394, 400,
               404, 414,
               422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583, 585, 587, 650, 652, 677, 691,
               730, 737,
               740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847, 858, 863, 863, 874, 887, 896, 916, 920,
               926, 927,
               930, 933, 957, 981, 997]

    # [24, 32]
    target = 542

    solution = Solution()
    res = solution.twoSum(numbers, target)
    print(res)
