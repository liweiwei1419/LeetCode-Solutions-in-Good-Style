class Solution:
    def sortColors(self, nums):
        l = len(nums)

        # 循环不变量的定义：
        # [0,zero] 中的元素全部等于 0
        # [zero+1,i) 中的元素全部等于 1
        # [two,l-1] 中的元素全部等于 2
        zero = -1
        two = l
        i = 0  # 马上要看的位置

        while i < two:
            if nums[i] == 0:
                zero += 1
                nums[zero], nums[i] = nums[i], nums[zero]
                i += 1
            elif nums[i] == 1:
                i += 1
            else:
                two -= 1
                nums[two], nums[i] = nums[i], nums[two]


if __name__ == '__main__':
    nums = [0, 2, 1, 1, 2, 2, 0, 0, 1]
    solution = Solution()
    solution.sortColors(nums)
    print(nums)
