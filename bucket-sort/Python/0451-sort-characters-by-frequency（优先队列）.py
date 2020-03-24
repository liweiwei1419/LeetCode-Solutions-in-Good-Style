class Solution:
    def frequencySort(self, s: str) -> str:
        size = len(s)
        if size <= 1:
            return s

        hash = dict()
        for alpha in s:
            hash[alpha] = hash.setdefault(alpha, 0) + 1

        import heapq
        h = []
        for alpha, counter in hash.items():
            heapq.heappush(h, (-counter, alpha))

        res = ''
        hash_table_len = len(hash.items())

        for _ in range(hash_table_len):
            counter, alpha = heapq.heappop(h)
            res += alpha * (-counter)
        return res


if __name__ == '__main__':
    string = 'tree'
    s = Solution()
    res = s.frequencySort(string)
    print(res)
