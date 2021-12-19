import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int len1 = A.length;
        int len2 = B.length;

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            int curStart = Math.max(A[i][0], B[j][0]);
            int curEnd = Math.min(A[i][1], B[j][1]);
            if (curStart <= curEnd) {
                res.add(new int[]{curStart, curEnd});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int size = res.size();
        int[][] resArr = new int[size][2];
        for (int k = 0; k < size; k++) {
            resArr[k] = res.get(k);
        }
        return resArr;
    }
}