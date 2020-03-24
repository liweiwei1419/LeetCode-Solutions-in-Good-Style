/**
 * @author liwei
 * @date 18/6/30 下午10:01
 */
public class Solution5 {

    public boolean isPowerOfTwo(int n) {
        // 1073741824 是小于 Integer.MAX_VALUE 中 2 的方幂的最大者
        // 该方法对于判定质数的方幂同样有效
        return n > 0 && 1073741824 % n == 0;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        boolean solution5PowerOfTwo = solution5.isPowerOfTwo(1);
        System.out.println(solution5PowerOfTwo);
    }
}
