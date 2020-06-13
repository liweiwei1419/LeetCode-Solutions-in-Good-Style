import java.util.Arrays;

public class Solution {

    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(A);
        // 打开调试
        // System.out.println(Arrays.toString(A));

        int preNum = A[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            // preNum + 1 表示当前数「最好」是这个值

            if (A[i] == preNum + 1) {
                preNum = A[i];
            } else if (A[i] > preNum + 1) {
                // 当前这个数已经足够大，这种情况可以合并到上一个分支
                preNum = A[i];
            } else {
                // A[i] < preNum + 1
                res += (preNum + 1 - A[i]);
                preNum++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 2};
        // int[] A = new int[]{3, 2, 1, 2, 1, 7};
        int res = solution.minIncrementForUnique(A);
        System.out.println(res);
    }
}
