class Solution:
    def numSub(self, s: str) -> int:

        def sum_of_preceding_n_terms(x):
            return (1 + x) * x // 2

        mod = 1000000000 + 7
        count = 0
        ones = 0
        for a in s:
            if a == '0':
                count += sum_of_preceding_n_terms(ones)
                ones = 0
                continue
            ones += 1
        count += sum_of_preceding_n_terms(ones)
        return count % mod


