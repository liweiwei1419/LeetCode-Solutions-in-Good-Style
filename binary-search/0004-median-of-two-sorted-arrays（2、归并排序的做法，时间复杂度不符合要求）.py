from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        # 最后要找到合并以后索引是 median_index 的这个数
        median_index = (m + n) >> 1

        # nums1 的索引
        i = 0
        # nums2 的索引
        j = 0

        # 计数器从 -1 开始，在循环开始之前加 1
        # 这样在退出循环的时候，counter 能指向它最后赋值的那个元素
        counter = -1

        res = [0, 0]
        while counter < median_index:
            counter += 1
            # 先写 i 和 j 遍历完成的情况，否则会出现数组下标越界
            if i == m:
                res[counter & 1] = nums2[j]
                j += 1
            elif j == n:
                res[counter & 1] = nums1[i]
                i += 1
            elif nums1[i] < nums2[j]:
                res[counter & 1] = nums1[i]
                i += 1
            else:
                res[counter & 1] = nums2[j]
                j += 1
            # print(res)
            # 每一次比较，不论是 nums1 中元素出列，还是 nums2 中元素出列
            # 都会选定一个数，因此计数器 + 1

        # 如果 m + n 是奇数，median_index 就是我们要找的
        # 如果 m + n 是偶数，有一点麻烦，要考虑其中有一个用完的情况，其实也就是把上面循环的过程再进行一步

        if (m + n) & 1:
            return res[counter & 1]
        else:
            return sum(res) / 2


if __name__ == '__main__':
    nums1 = [1, 3]
    nums2 = [2]

    solution = Solution()
    res = solution.findMedianSortedArrays(nums1, nums2)
    print(res)
