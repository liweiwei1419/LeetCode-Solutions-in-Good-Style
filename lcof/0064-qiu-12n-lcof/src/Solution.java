public class Solution {

    public int sumNums(int n) {
        int sum = n;
        boolean res = n > 0 && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}
