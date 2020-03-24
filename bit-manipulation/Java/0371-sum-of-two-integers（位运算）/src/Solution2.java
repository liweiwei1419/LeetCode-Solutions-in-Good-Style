public class Solution2 {

    public int getSum(int a, int b) {
        int sum;
        int carry;
        do {
            sum = a ^ b;
            carry = a & b;

            a = sum;
            b = carry << 1;
        } while (carry != 0);
        return sum;
    }
}
