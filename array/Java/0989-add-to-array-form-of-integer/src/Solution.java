import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liwei
 * @date 2019/9/4 10:26 PM
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int i = len - 1;
        int curSum;
        int carry = 0;
        while (i >= 0 || K > 0) {
            curSum = carry;
            if (i >= 0) {
                curSum += A[i];
                i--;
            }
            if (K > 0) {
                curSum += K % 10;
                K /= 10;
            }
            if (curSum >= 10) {
                curSum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            stack.add(curSum);
        }
        if (carry == 1) {
            stack.add(1);
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }


    private void checkUser(){

    }
}