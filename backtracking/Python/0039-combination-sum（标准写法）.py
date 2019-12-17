from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)
        if size == 0:
            return []
        # 排序为了后续剪枝
        candidates.sort()
        res = []
        self.__dfs(candidates, size, 0, [], target, res)
        return res

    def __dfs(self, candidates, size, start, path, residue, res):
        """
        :param candidates: 无重复元素的数组
        :param size: 数组的长度，避免一直使用 len(candidates)
        :param start: 从 candidates 索引的第几位开始考虑
        :param path: 深度优先搜索沿途经过的路径
        :param residue: 剩余值
        :param res: 存放结果集的列表
        :return:
        """
        if residue == 0:
            res.append(path[:])
            return

        for index in range(start, size):
            # 因为我们已经将数组预处理成升序数组，一旦发现当前遍历的数比剩余值还大，循环就可以停止了
            if residue - candidates[index] < 0:
                break
            path.append(candidates[index])
            # 注意：因为数字可以无限制重复被选取，因此起始位置还是自己
            self.__dfs(candidates, size, index, path, residue - candidates[index], res)
            path.pop()


if __name__ == '__main__':
    candidates = [2, 3, 6, 7]
    target = 7
    solution = Solution()
    result = solution.combinationSum(candidates, target)
    print(result)
