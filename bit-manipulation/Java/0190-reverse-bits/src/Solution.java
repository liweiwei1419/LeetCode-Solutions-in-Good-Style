public class Solution {
    // you need treat n as an unsigned value

    // 00000010100101000001111010011100
    //       10100101000001111010011100

    /**
     * 比较简单粗暴，拿字符串转来转去
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        String toBinaryString = Long.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder(toBinaryString);
        // 不够 32 位的左补 0
        while (stringBuilder.length() < 32) {
            stringBuilder.insert(0, 0);
        }
        String str = stringBuilder.reverse().toString();
        return Integer.valueOf(str, 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 43261596;
        int reverseBits = solution.reverseBits(n);
        System.out.println(reverseBits);
    }
}