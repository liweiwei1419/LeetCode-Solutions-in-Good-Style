public class Solution2 extends VersionControl {

    /**
     * @param n n 是所有的版本数
     * @return 第一个出错的版本
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        // 注意：这里使用的是小于号
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}