class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        nums = arr
        if k == 0:
            return []
        if len(arr) <= k:
            return arr

        def partition_slow(low, high):
            x = nums[low]
            i = high + 1

            for j in range(high, low, -1):
                if nums[j] > x:
                    i -= 1
                    nums[i], nums[j] = nums[j], nums[i]
            i -= 1
            nums[i], nums[low] = nums[low], nums[i]
            return i

        def partition_fast(lo, hi):
            nonlocal nums
            # print(lo,hi)
            v = nums[lo]
            i = lo

            for j in range(lo + 1, hi + 1):
                if nums[j] < v:
                    i += 1
                    nums[j], nums[i] = nums[i], nums[j]
            nums[i], nums[lo] = nums[lo], nums[i]
            return i

        n = len(arr)
        low, high = 0, n - 1
        kk = k
        partition = partition_fast
        # partition = partition_slow
        while kk > 0 and kk <= high - low + 1:
            # while True:
            pivot = partition(low, high)
            # print('pivot:{} kk:{} low:{} high:{} nums:{}'.format(
            #     pivot, kk, low, high, nums))
            if pivot - low == kk - 1:
                break
            elif pivot - low > kk - 1:
                high = pivot - 1
            else:
                kk = kk - pivot + low - 1
                low = pivot + 1
        return nums[:k]
