class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = dict()

        for index, num in enumerate(nums):
            if target - num not in map.keys():
                map[num] = index
            else:
                result = []
                result.append(index)
                result.append(map[target - num])
                return result


if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9

    solution = Solution()

    result = solution.twoSum(nums, target)
    print(result)
