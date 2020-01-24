import java.util.List;

public class Solution3 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = 1; i < len; i++) {
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
            triangle.get(i).set(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }

        int res = triangle.get(len - 1).get(0);
        for (int i = 1; i < len; i++) {
            res = Math.min(res, triangle.get(len - 1).get(i));
        }
        return res;
    }
}
