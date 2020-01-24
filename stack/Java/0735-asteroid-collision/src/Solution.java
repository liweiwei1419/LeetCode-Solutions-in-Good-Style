import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {

                    if (stack.peek() + asteroid < 0) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() + asteroid == 0) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(asteroid);
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        int index = size - 1;
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] asteroids = new int[]{5, 10, -5};
        // int[] asteroids = new int[]{8, -8};
        // int[] asteroids = new int[]{10, 2, -5};
        int[] asteroids = new int[]{-2, -2, 1, -2};
        Solution solution = new Solution();

        int[] res = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(res));
    }
}
