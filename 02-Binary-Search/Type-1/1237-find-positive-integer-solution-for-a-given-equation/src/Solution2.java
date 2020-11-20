import java.util.ArrayList;
import java.util.List;


public class Solution2 {

    // 注意：起点都是 1，终点是 1000

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            // 只会有一个解，并且是单调上升的，把每一行查找变成二分查找
            int left = 1;
            int right = 1000;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (customfunction.f(i, mid) < z) {
                    // 下一轮搜索区间在 [mid + 1, right]
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }
            if (customfunction.f(i, left) == z) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                cur.add(left);
                res.add(cur);
            }
        }
        return res;
    }
}