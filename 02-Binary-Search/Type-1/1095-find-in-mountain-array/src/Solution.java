interface MountainArray {
    public int get(int index);

    public int length();
}

public class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int peakIndex = findMountainTop(mountainArr, 0, len - 1);
        if (mountainArr.get(peakIndex) == target) {
            return peakIndex;
        }

        int res = findAscendArray(mountainArr, 0, peakIndex - 1, target);
        if (res != -1) {
            return res;
        }
        return findDescendArray(mountainArr, peakIndex + 1, len - 1, target);
    }

    /**
     * 在 [left..right] 查找山顶元素的下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @return
     */
    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 下一轮搜索区间 [mid + 1,right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 在 [left, right] 查找 target 下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int findAscendArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                // 下一轮搜索区间 [mid+1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }

        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }

    /**
     * 在 [left, right] 查找 target 的下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int findDescendArray(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间[left, mid]
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        }
        return -1;
    }
}