import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/29 1:33 下午
 */
interface CustomFunction {
    public int f(int x, int y);
};


public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1000;

        while (left <= 1000 && right >= 1) {
            int num = customfunction.f(left, right);
            if (num == z) {
                List<Integer> cur = new ArrayList<>();
                cur.add(left);
                cur.add(right);
                res.add(cur);

                left++;
                right--;

            } else if (num > z) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
