import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && asteroid < 0 && stack.peekLast() > 0) {

                    if (stack.peekLast() + asteroid < 0) {
                        stack.removeLast();
                        continue;
                    } else if (stack.peekLast() + asteroid == 0) {
                        stack.removeLast();
                    }
                    break collision;
                }
                stack.addLast(asteroid);
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        int index = size - 1;
        while (!stack.isEmpty()) {
            res[index] = stack.removeLast();
            index--;
        }
        return res;
    }
}