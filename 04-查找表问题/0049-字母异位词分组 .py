class Solution:
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """

        l = len(strs)
        if l <= 1:
            return [strs]

        d = dict()
        for s in strs:
            sorted_str = ''.join(sorted(list(s)))
            # print(s, '1', sorted_str)
            if d.get(sorted_str) is None:
                d[sorted_str] = [s]
            else:
                d[sorted_str].append(s)
        return list(d.values())


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    solution = Solution()
    result = solution.groupAnagrams(strs)
    print(result)
