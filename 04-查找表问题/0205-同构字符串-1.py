class Solution:
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        return len(set(s)) == len(set(t)) == len(set(zip(s, t)))


if __name__ == '__main__':
    s = "egg"
    t = "add"
    solution = Solution()
    result = solution.isIsomorphic(s, t)
    print(result)
