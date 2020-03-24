public class Solution3 {
    // 还可以再节约一些空间

    public int binaryGap(int N) {
        // 因为是正数，所以 31 位就可以了
        int[] index = new int[31];
        // 有数字 1 的索引
        int oneIndex = 0;
        int mask = 1;
        for (int i = 0; i < 31; i++) {
            if ((N & mask) != 0) {
                index[oneIndex] = i;
                oneIndex++;
            }
            mask <<= 1;
        }
        int res = 0;
        for (int i = 0; i < oneIndex - 1; i++) {
            res = Math.max(res, index[i + 1] - index[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int binaryGap = solution3.binaryGap(22);
        System.out.println(binaryGap);
    }
}
