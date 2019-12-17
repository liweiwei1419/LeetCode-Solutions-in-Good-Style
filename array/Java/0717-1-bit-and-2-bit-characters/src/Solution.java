public class Solution {

    // 有点贪心算法的意思
    // 遍历数组，至倒数第二位数，遍历规则是遇 0 加一，遇 1 加二，若数组以 0 结尾，则 i = n-1 ；若以 10 结尾，则 i=n 。

    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return true;
        }
        int i = 0;
        // 最多看到 len-2 ，len - 1 不用看了
        // 1 0 1 1 1 1 0
        // 1 0 1 1 1 0 0
        while (i < len - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == len - 1;
    }

    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        Solution solution = new Solution();
        boolean oneBitCharacter = solution.isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);
    }
}
