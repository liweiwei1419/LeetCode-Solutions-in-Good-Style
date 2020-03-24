import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/12/1 1:56 下午
 */
public class Solution2 {

    private int f(int x, int y) {
        return 4 * x + 2 * y;
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // 两边夹，搜索 a 的值
        int left = 0;
        int right = tomatoSlices / 4;

        while (left < right) {
            int mid = (left + right) >>> 1;
            // 根据方程 x + y = b
            int y = cheeseSlices - mid;

            // f 函数计算了方程 4x + 2y = a 的左边
            if (f(mid, y) < tomatoSlices) {
                // 下一轮搜索区间在 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> res = new ArrayList<>(2);
        if (f(left, cheeseSlices - left) == tomatoSlices) {
            res.add(left);
            res.add(cheeseSlices - left);
        }
        return res;
    }
}
