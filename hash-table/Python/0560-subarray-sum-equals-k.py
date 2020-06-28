from typing import List
from random import randint


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        d = {0: [-1]}
        res = 0
        pre = 0
        for idx, num in enumerate(nums):
            pre += num
            diff = pre - k
            if diff in d:
                for j_1 in d[diff]:
                    # 因为 diff = d[pre[j-1]]，因此j的下标+1，而 0设置为-1的目的就是如此
                    print(f'start:{j_1 + 1} end:{idx} seq:{nums[j_1 + 1:idx + 1]}')
                res += len(d[diff])
            d.setdefault(pre, []).append(idx)
        return res


if __name__ == '__main__':
    nums = [randint(1, 30) for _ in range(randint(1, 20))]
    k = randint(5, 20)
    print(nums)
    print(k)
    print(Solution().subarraySum(nums, k))
