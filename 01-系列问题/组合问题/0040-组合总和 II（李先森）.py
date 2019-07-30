from typing import List

# 本代码介绍了如何调试

class Solution:

    def backtrack(self, candidates, start, residue, p, output, depth):
        print('  ' * depth, 'depth ', depth, 'residue', residue, )
        if residue == 0:
            output.append(p.copy())
            return
        for index in range(start, len(candidates)):
            if candidates[index] > residue:
                break
            if index > start and candidates[index - 1] == candidates[index]:
                continue
            p.append(candidates[index])
            # 由于不可重复，故截取 index 之后的数组进行递归操作
            # 【下面这句特别容易出错】，不要写成 start + 1
            self.backtrack(candidates, index + 1, residue - candidates[index], p, output, depth + 1)
            p.pop()

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        # 首先对数组排序
        candidates.sort()
        print(candidates)
        output = []
        self.backtrack(candidates, 0, target, [], output, 0)
        return output


if __name__ == '__main__':
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8

    # candidates = [2, 5, 2, 1, 2]
    # target = 5
    solution = Solution()
    result = solution.combinationSum2(candidates, target)
    print(result)
