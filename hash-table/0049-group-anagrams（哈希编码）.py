from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        # 26 个质数
        primes = [2, 3, 5, 7, 11,
                  13, 17, 19, 23, 29,
                  31, 37, 41, 43, 47,
                  53, 59, 61, 67, 71,
                  73, 79, 83, 89, 97,
                  101]

        # hash_arr 中存放的是与 res 对应的 hash 值
        hash_arr = []
        res = []

        for s in strs:
            hash_val = 1
            for alpha in s:
                hash_val *= primes[ord(alpha) - ord('a')]
            index = 0
            while index < len(hash_arr):
                if hash_arr[index] == hash_val:
                    res[index].append(s)
                    break
                index += 1
            if index == len(hash_arr):
                hash_arr.append(hash_val)
                res.append([s])
        return res


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    solution = Solution()
    result = solution.groupAnagrams(strs)
    print(result)
