class VersionControl {

    /**
     * 这个实现是我为了编译成功写上去的
     *
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return version >= 5;
    }
}

class VersionControl1 {
    boolean isBadVersion(int version) {
        // 为了本地编译通过，硬编码
        return version >= 13;
    }
}

public class Solution extends VersionControl {

    /**
     * @param n n 是所有的版本数
     * @return 第一个出错的版本
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        // 1 2 3 4 4 4 4 4 4 4
        // 注意：这里是小于，不是等于
        while (left < right) {
            // 临近的时候靠左边，所以判断左边不是的时候，就一定要加上去
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}