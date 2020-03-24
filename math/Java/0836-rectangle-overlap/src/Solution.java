public class Solution {

    // 从判断两条线段是否有交点推广开来

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean rowsOk = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
        boolean colsOk = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
        return rowsOk && colsOk;
    }
}
