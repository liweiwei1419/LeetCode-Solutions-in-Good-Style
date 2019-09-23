from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        size = len(strs)
        if size <= 1:
            return [strs]

        hash = dict()
        for s in strs:
            sorted_str = ''.join(sorted(list(s)))
            # print(s, '1', sorted_str)
            if hash.get(sorted_str) is None:
                hash[sorted_str] = [s]
            else:
                hash[sorted_str].append(s)
        return list(hash.values())


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    solution = Solution()
    result = solution.groupAnagrams(strs)
    print(result)
