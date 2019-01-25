class Solution:
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """

        l = len(s)
        if l <= 1:
            return s

        d = dict()
        for alpha in s:
            d[alpha] = d.setdefault(alpha, 0) + 1
        # print(d.items())

        import heapq
        h = []
        for alpha, counter in d.items():
            heapq.heappush(h, (-counter, alpha))
        res = ''

        dl = len(d.items())

        for _ in range(dl):
            counter, alpha = heapq.heappop(h)
            res += alpha * (-counter)
        return res


if __name__ == '__main__':
    string = 'tree'
    s = Solution()
    res = s.frequencySort(string)
    print(res)
