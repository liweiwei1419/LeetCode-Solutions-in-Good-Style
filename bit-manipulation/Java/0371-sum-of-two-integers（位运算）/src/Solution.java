public class Solution {

    public int getSum(int a, int b) {
        int sum;
        while (true) {
            sum = a ^ b;
            int carry = a & b;
            if (carry == 0) {
                break;
            }
            a = sum;
            b = carry << 1;
        }
        return sum;
    }
}
