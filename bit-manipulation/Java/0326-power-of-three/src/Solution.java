import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    // 打表法
    public boolean isPowerOfThree(int n) {
        int[] nums = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.contains(n);
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        int n = 1;
        System.out.println(Integer.MAX_VALUE);
        while (n > 0 && n < 2147483647) {
            res.add(n);
            n = n * 3;
        }
        System.out.println(res);
    }
}
