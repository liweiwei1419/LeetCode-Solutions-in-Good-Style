import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];

                while (!stack.isEmpty() &&  heights[stack.peekLast()] == height){
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()){
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }

                area = Math.max(area , width * height);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()){
            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() &&  heights[stack.peekLast()] == height){
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()){
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }

            area = Math.max(area , width * height);
        }
        return area;
    }
}
