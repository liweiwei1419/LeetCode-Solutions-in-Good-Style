class Solution:
    def sortColors(self, nums):
        size = len(nums)

        # 循环不变量的定义：
        # [0, zero] 中的元素全部等于 0
        # (zero, i) 中的元素全部等于 1
        # [two, size - 1] 中的元素全部等于 2
        # 下面的这 3 个变量初始值保证了上面 3 个集合为空集
        zero = -1
        two = size
        i = 0  # 马上要看的索引位置

        while i < two:
            # nums[two] 的元素其实我们是清楚的，所以是 <
            if nums[i] == 0:
                zero += 1
                # 把 0 交换到前面
                nums[zero], nums[i] = nums[i], nums[zero]
                i += 1
            elif nums[i] == 1:
                # 直接跳过
                i += 1
            else:
                # 把 2 交换到后面
                two -= 1
                nums[two], nums[i] = nums[i], nums[two]


if __name__ == '__main__':
    nums = [0, 2, 1, 1, 2, 2, 0, 0, 1]
    solution = Solution()
    solution.sortColors(nums)
    print(nums)
