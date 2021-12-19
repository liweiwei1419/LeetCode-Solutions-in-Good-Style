public class Solution3 {

    // 调试代码

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            // 取中间数 mid 下取整时
            int mid = left + (right - left) / 2;

            // 调试语句开始
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
            // 调试语句结束

            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        int x = 9;
        int res = solution2.mySqrt(x);
        System.out.println(res);
    }
}