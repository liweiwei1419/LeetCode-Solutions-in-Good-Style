from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hash = dict()
        if len(strs) == 0:
            return []
        for s in strs:
            key = ''.join(sorted(list(s)))
            if key not in hash:
                hash[key] = [s]
            else:
                hash[key].append(s)
        return list(hash.values())


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    solution = Solution()
    result = solution.groupAnagrams(strs)
    print(result)
