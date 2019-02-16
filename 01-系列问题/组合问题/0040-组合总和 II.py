class Solution:
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        length = len(candidates)
        if length == 0:
            return []
        candidates.sort()
        print(candidates)
        res = []

        self.__dfs(candidates, length, 0, [], target, res)
        return res

    def __dfs(self, candidates, length, start, path, residue, res):
        if residue == 0:
            res.append(path[:])
            return

        for index in range(start, length):
            if candidates[index] > residue:
                break

            # 剪枝的前提是数组升序排序
            if index > start and candidates[index - 1] == candidates[index]:
                # [1, 1, 2, 5, 6, 7, 10]
                # 0 号索引的 1 ，从后面 6 个元素中搜索
                # 1 号索引也是 1 ，从后面 5 个元素（是上面 6 个元素的真子集）中搜索，这种情况显然上面已经包含
                continue

            path.append(candidates[index])
            # 这里要传入 index + 1，因为当前元素不能被重复使用
            # 如果 index + 1 越界，传递到下一个方法中，什么也不执行
            self.__dfs(candidates, length, index + 1, path, residue - candidates[index], res)
            path.pop()


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8

    # candidates = [2, 5, 2, 1, 2]
    # target = 5
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
