import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/12/3 11:11 上午
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        // 特判
        if (len < 2) {
            return new int[len];
        }
        int[] res = new int[len];
        res[len - 1] = 0;
        for (int i = 0; i < len - 1; i++) {
            int curVal = T[i];
            for (int j = i + 1; j < len; j++) {
                if (T[j] > curVal) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int[] res = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}
