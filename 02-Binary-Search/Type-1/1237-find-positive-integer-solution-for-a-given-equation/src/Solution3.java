import java.util.ArrayList;
import java.util.List;


public class Solution3 {

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