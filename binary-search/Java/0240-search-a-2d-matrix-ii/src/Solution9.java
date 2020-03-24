public class Solution9 {

    private int diagonalBinarySearch(int[][] matrix, int diagonal, int target) {
        int left = 0;
        int right = diagonal;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (matrix[mid][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 下面两个二分查找没有使用模板，因为只是找一个数，而不是找这个数的边界
    // 用教科书上的二分查找法更简单

    private boolean rowBinarySearch(int[][] matrix, int begin, int cols, int target) {
        int left = begin;
        int right = cols;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (matrix[begin][mid] == target) {
                return true;
            } else if (matrix[begin][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private boolean colBinarySearch(int[][] matrix, int begin, int rows, int target) {
        // 这里可以 + 1
        int left = begin + 1;
        int right = rows;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (matrix[mid][begin] == target) {
                return true;
            } else if (matrix[mid][begin] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 特判
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }


        int minVal = Math.min(rows, cols);
        // 沿着对角线搜索第 1 个大于等于 target 的数的索引
        int index = diagonalBinarySearch(matrix, minVal - 1, target);
        if (matrix[index][index] == target) {
            return true;
        }

        // 沿着对角线朝两边搜索
        for (int i = 0; i <= index; i++) {
            // 行搜索传入列总数 - 1
            boolean rowSearch = rowBinarySearch(matrix, i, cols - 1, target);
            // 列搜索传入行总数 - 1
            boolean colSearch = colBinarySearch(matrix, i, rows - 1, target);

            if (rowSearch || colSearch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        Solution9 solution9 = new Solution9();
        boolean searchMatrix = solution9.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
