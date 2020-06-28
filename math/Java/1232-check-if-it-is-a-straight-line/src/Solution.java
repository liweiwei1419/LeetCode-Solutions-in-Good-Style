public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        // 2 个点一定在一条直线上，所以从 i = 3 开始判断就好了

        int len = coordinates.length;
        for (int i = 3; i < len; i++) {
            if ((coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0])
                    != (coordinates[i][1] - coordinates[0][1]) * (coordinates[1][0] - coordinates[0][0])) {
                return false;
            }
        }
        return true;
    }
}
