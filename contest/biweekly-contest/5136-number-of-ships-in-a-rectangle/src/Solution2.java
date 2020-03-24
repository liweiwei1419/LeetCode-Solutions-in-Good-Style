public class Solution2 {

    /**
     * 根据提示 1 使用分治法
     *
     * @param sea
     * @param topRight   右上角的点
     * @param bottomLeft 左下角的点
     * @return
     */
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        // 用 X 表示横坐标，用 Y 表示纵坐标
        // 右上角的横坐标、纵坐标
        int topRightX = topRight[0];
        int topRightY = topRight[1];

        // 左下角的横坐标、纵坐标
        int bottomLeftX = bottomLeft[0];
        int bottomLeftY = bottomLeft[1];

        // 先写递归终止条件，即考虑什么样的右上角的点和左下角的点不构成区间
        // 1、不构成区间：（1）左下角的点的横坐标 > 右上角的点的横坐标；（2）左下角的点的纵坐标 > 右上角的点的纵坐标
        // 2、像扫雷一样，扫不到船只，就返回 0，
        if (bottomLeftX > topRightX || bottomLeftY > topRightY || !sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        // 如果都挤到一个点了，这是最基本的情况，注意：这里是并且，hasShips 的调用顺序是先右上，再左下
        // 这里不必再判断一次
        // sea.hasShips(new int[]{topRightX, topRightY}, new int[]{bottomLeftX, bottomLeftY}
        if (bottomLeftX == topRightX && bottomLeftY == topRightY) {
            return 1;
        }

        // 分治法，不管怎么样都一分为二
        int midX = (bottomLeftX + topRightX) >>> 1;
        int midY = (bottomLeftY + topRightY) >>> 1;

        // 把四个子区域的右上角和左下角坐标写成数组
        // 搜索顺序（顺时针，可打乱）：左上角、右上角、右下角、左下角
        int[][][] blocks = new int[][][]{
                {{midX, topRightY}, {bottomLeftX, midY + 1}},
                {{topRightX, topRightY}, {midX + 1, midY + 1}},
                {{topRightX, midY}, {midX + 1, bottomLeftY}},
                {{midX, midY}, {bottomLeftX, bottomLeftY}}};

        int res = 0;
        for (int[][] block : blocks) {
            int[] topRightCoord = block[0];
            int[] bottomLeftCoord = block[1];
            res += countShips(sea, topRightCoord, bottomLeftCoord);
            // 题目保证矩形内至多只有 10 艘船，因此，如果当前扫描到等于 10 只就不必继续搜索下去
            // 这一步操作是剪枝
            if (res == 10) {
                return res;
            }
        }
        return res;
    }
}