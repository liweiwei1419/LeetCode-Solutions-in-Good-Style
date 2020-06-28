public class Solution {

    // 出度为 0 入度为 N 的就是法官

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int[] t : trust) {
            // t[0] 出，t[1] 入
            outDegree[t[0]]++;
            inDegree[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
