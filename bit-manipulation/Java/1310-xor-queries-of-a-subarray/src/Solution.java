import java.util.Arrays;

public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int qLen = queries.length;
        int[] res = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int leftIndex = queries[i][0];
            int rightIndex = queries[i][1];

            int curRes = 0;
            for (int j = leftIndex; j <= rightIndex; j++) {
                curRes ^= arr[j];
            }
            res[i] = curRes;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}};


//        int[] arr = {4, 8, 2, 10};
//        int[][] queries = new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}};

//        int[] arr = {16};
//        int[][] queries = new int[][]{{0,0}, {0,0}, {0, 0}, {0,0}};


        int[] res = solution.xorQueries(arr, queries);
        System.out.println(Arrays.toString(res));
    }
}
