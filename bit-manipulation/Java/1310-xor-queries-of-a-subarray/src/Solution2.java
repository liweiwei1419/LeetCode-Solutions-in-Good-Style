import java.util.Arrays;

public class Solution2 {


    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;

        // 得到前缀异或和数组
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] ^ arr[i];
        }

        int qLen = queries.length;
        int[] res = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // 注意：这里也是取异或
            res[i] = preSum[right + 1] ^ preSum[left];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}};


//        int[] arr = {4, 8, 2, 10};
//        int[][] queries = new int[][]{{2, 3}, {1, 3}, {0, 0}, {0, 3}};

//        int[] arr = {16};
//        int[][] queries = new int[][]{{0,0}, {0,0}, {0, 0}, {0,0}};


        int[] res = solution2.xorQueries(arr, queries);
        System.out.println(Arrays.toString(res));
    }
}
