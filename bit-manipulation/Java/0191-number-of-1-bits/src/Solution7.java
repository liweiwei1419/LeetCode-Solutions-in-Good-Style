public class Solution7 {

    public int hammingWeight(int n) {
        int res = 0;

        if (n < 0) {
            res++;
            n = -1 * n;
        }

        while (n != 0) {
            if (n % 2 == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        for (int i = -100; i < 100; i++) {
            int hammingWeight = solution7.hammingWeight(i);
            System.out.printf("%d ", hammingWeight);
            System.out.println(Integer.bitCount(i));
        }
        System.out.println("11111111111111111111111111111111".length());

        // 极端测试用例
        // 4294967295 (11111111111111111111111111111111)
        System.out.println((long) 1 << 32);
    }
}
