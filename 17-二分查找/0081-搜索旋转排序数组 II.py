class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        size = len(nums)
        if size == 0:
            return False
        l = 0
        r = size - 1
        while l < r:
            mid = l + (r - l + 1) // 2
            if nums[mid] < nums[r]:
                # 后面是有序的
                # [2,3,4,5,5,6,6,7]
                if nums[mid] <= target <= nums[r]:
                    l = mid
                else:
                    r = mid - 1
            elif nums[mid] > nums[r]:
                # [3,4,5,5,6,6,7,2]

                if nums[l] <= target <= nums[mid - 1]:
                    r = mid - 1
                else:
                    l = mid
            else:
                assert nums[mid] == nums[r]
                if nums[r] == target:
                    return True
                # 右边不是才删除
                r = r - 1
        return nums[l] == target


if __name__ == '__main__':
    nums = [1, 3]
    target = 3
    solution = Solution()

    result = solution.search(nums, target)
    print(result)
