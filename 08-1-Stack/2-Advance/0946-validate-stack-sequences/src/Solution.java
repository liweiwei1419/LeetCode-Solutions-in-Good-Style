import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len1 = pushed.length;
        int len2 = popped.length;
        if (len1 == 0 && len2 == 0){
            return true;
        }
        if (len2 == 0 || len1 != len2) {
            return false;
        }

        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len1; i++) {
            stack.addLast(pushed[i]);
            while (!stack.isEmpty() && stack.peekLast() == popped[index]) {
                stack.removeLast();
                index++;
            }
        }
        return stack.isEmpty();
    }
}