class Solution:
    def sortColors(self, nums):
        n = len(nums)
        zero = 0  # 马上 0 要呆的位置
        i = 0  # 马上要看的位置
        two = n  # 表示应确定的位置，一开始没有
        while i < two:
            if nums[i] == 0:
                self.__swap(nums, zero, i)
                zero += 1
                i += 1
            elif nums[i] == 1:
                i += 1
            else:
                two -= 1
                self.__swap(nums, two, i)

    def __swap(self, nums, idx_1, idx_2):
        if idx_1 == idx_2:
            return
        temp = nums[idx_1]
        nums[idx_1] = nums[idx_2]
        nums[idx_2] = temp


if __name__ == '__main__':
    nums = [2]
    solution = Solution()
    solution.sortColors(nums)
    print(nums)
