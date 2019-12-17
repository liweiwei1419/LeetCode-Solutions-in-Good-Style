# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
class MountainArray:
    def __init__(self, arr):
        self.arr = arr
        self.size = len(arr)

    def get(self, index: int) -> int:
        return self.arr[index]

    def length(self) -> int:
        return self.size


class Solution:

    # 特别注意：3 个辅助方法的分支出奇地一样，因此选中位数均选左中位数，才不会发生死循环

    def findInMountainArray(self, target: int, mountain_arr: 'MountainArray') -> int:
        size = mountain_arr.length()
        # 步骤 1：先找到山顶元素所在的索引
        mountaintop = self.__find_mountaintop(mountain_arr, 0, size - 1)
        # 步骤 2：在前有序且升序数组中找 target 所在的索引
        res = self.__find_from_sorted_arr(mountain_arr, 0, mountaintop, target)
        if res != -1:
            return res
        # 步骤 3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
        return self.__find_from_inversed_arr(mountain_arr, mountaintop + 1, size - 1, target)

    def __find_mountaintop(self, mountain_arr: 'MountainArray', left: int, right: int):
        # 返回山顶元素
        while left < right:
            mid = (left + right) >> 1
            # 取左中位数，因为进入循环，数组一定至少有 2 个元素
            # 因此，左中位数一定有右边元素，数组下标不会发生越界
            if mountain_arr.get(mid) < mountain_arr.get(mid + 1):
                # 如果当前的数比右边的数小，它一定不是山顶
                left = mid + 1
            else:
                right = mid
        # 根据题意，山顶元素一定存在，因此退出 while 循环的时候，不用再单独作判断
        return left

    def __find_from_sorted_arr(self, mountain_arr: 'MountainArray', left: int, right: int, target: int):
        # 在前有序且升序数组中找 target 所在的索引
        while left < right:
            mid = (left + right) >> 1
            if mountain_arr.get(mid) < target:
                left = mid + 1
            else:
                right = mid
        # 后处理，因为不确定区间收缩成 1 个数以后，这个数是不是要找的数，因此单独做一次判断
        if mountain_arr.get(left) == target:
            return left
        return -1

    def __find_from_inversed_arr(self, mountain_arr: 'MountainArray', left: int, right: int, target: int):
        # 在后有序且降序数组中找 target 所在的索引
        while left < right:
            mid = (left + right) >> 1
            # 与 __find_from_sorted_arr 方法不同的地方仅仅在于由原来的小于号改成大于号
            if mountain_arr.get(mid) > target:
                left = mid + 1
            else:
                right = mid
        # 后处理，因为不确定区间收缩成 1 个数以后，这个数是不是要找的数，因此单独做一次判断
        if mountain_arr.get(left) == target:
            return left
        return -1


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 3, 1]
    mountain_array = MountainArray(arr)
    target = 3
    solution = Solution()
    res = solution.findInMountainArray(target, mountain_array)
    print('res', res)
