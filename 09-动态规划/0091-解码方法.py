# @Time    : 18/4/10 下午1:58
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


class Solution:


    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """




        return self._ways(s, len(s) - 1)


if __name__ == '__main__':
    test_str = '12'
    s = Solution()
    res = s.numDecodings(test_str)
    print(res)
