class Solution:
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        map = dict()

        if len(strs) == 0:
            return []

        for s in strs:
            key = ''.join(sorted(list(s)))
            if key not in map:
                map[key] = [s]
            else:
                map[key].append(s)

        return list(map.values())


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    solution = Solution()
    result = solution.groupAnagrams(strs)
    print(result)
