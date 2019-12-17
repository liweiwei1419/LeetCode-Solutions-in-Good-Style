import java.util.Arrays;

public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        if (row == 0) {
            return nums;
        }
        int col = nums[0].length;
        // 如果型号不相等，则没有办法转换，根据题意，直接返回原始矩阵
        if (row * col != r * c) {
            return nums;
        }
        int[][] ret = new int[r][c];
        // 设置一个计数器
        int counter = 0;
        // 新矩阵的行坐标
        int x = 0;
        // 在遍历原矩阵的时候就可以直接给新矩阵赋值了
        // 规则就是从左向右，如果越界了，就重置，并且行号加 1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[x][counter] = nums[i][j];
                counter++;
                if (counter == c) {
                    // 越界，重置列坐标，行号 + 1
                    counter = 0;
                    x++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12}
        };
        int r = 4;
        int c = 3;
        Solution solution = new Solution();
        int[][] matrixReshape = solution.matrixReshape(nums, r, c);
        for (int i = 0; i < matrixReshape.length; i++) {
            System.out.println(Arrays.toString(matrixReshape[i]));
        }
    }
}
