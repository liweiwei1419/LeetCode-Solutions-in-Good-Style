import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/2 3:48 下午
 */
interface CustomFunction {
    public int f(int x, int y);
}

public class Solution {

    // 注意：起点都是 1，终点是 1000

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }
}