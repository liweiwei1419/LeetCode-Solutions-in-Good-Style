import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    // 暴力解法，一行一行，从左到右搜索结果

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (customfunction.f(i, 1) > z) {
                break;
            }
            for (int j = 1; j <= 1000; j++) {
                if (customfunction.f(i, 1) == z) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                    break;
                } else if (customfunction.f(i, j) > z) {
                    break;
                }
            }
        }
        return res;
    }
}