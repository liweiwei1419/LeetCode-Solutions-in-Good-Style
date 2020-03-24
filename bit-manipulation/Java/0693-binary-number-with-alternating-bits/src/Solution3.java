/**
 * @author liwei
 * @date 18/6/29 下午9:05
 */
public class Solution3 {

    public boolean hasAlternatingBits(int n) {
        String nStr = Integer.toBinaryString(n);
        // 因为是正数，所以一定以 1 开头
        return nStr.matches("(10)*1?");
    }
}
