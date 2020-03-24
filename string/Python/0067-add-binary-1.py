class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a, 2) + int(b, 2))[2:]


if __name__ == '__main__':
    a = "11"
    b = "1"
    solution = Solution()
    result = solution.addBinary(a, b)
    print(result)

    result1 = int(a, 2)
    result2 = int(b, 2)
    print(result1)
    print(result2)

    print(bin(result1 + result2))
    print(bin(result1 + result2)[2:])
