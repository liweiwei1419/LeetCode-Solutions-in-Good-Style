class Solution:
    def getPermutation(self, n: int, k: int) -> str:

        def sorts(n, string, index, used, res):

            if index == n:
                res.append(string)
                return

            for i in range(1, n + 1):

                if not used[i]:
                    used[i] = True
                    sorts(n, string + str(i), index + 1, used, res)
                    used[i] = False

        def factorial(n):
            if n == 0:
                return 1
            else:
                return n * factorial(n - 1)

        if n < 1 or n > 9 or k < 1 or k > factorial(n):  # or k>n!
            return None

        cur_str = ''
        index = 0
        res = []
        used = [False for _ in range(n + 1)]
        sorts(n, cur_str, index, used, res)

        print(len(res))
        return res[k - 1]


def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)


if __name__ == '__main__':
    solution = Solution()
    n = 9
    k = 24

    print(factorial(n))
    # res = solution.getPermutation(n, k)
    # print(res)
