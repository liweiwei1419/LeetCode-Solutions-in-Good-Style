import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 镜面反射
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
