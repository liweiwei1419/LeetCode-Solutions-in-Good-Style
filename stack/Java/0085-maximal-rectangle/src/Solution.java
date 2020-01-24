import java.util.Arrays;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        

    }

    public static void main(String[] args) {
//        char[][] matrix = new char[][]{
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1', '1'}};


        Solution solution = new Solution();
        int res = solution.maximalRectangle(matrix);
        System.out.println(res);

    }
}
