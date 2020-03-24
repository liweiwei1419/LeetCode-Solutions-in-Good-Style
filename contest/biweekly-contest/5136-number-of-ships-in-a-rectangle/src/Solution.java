/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface Sea {
    boolean hasShips(int[] topRight, int[] bottomLeft);
}

public class Solution {

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

        int res = 0;
        // 如果都挤到一个点了，这是最基本的情况，注意：这里是并且，hasShips 的调用顺序是先右上，再左下
        // 这里不必再判断一次
        // sea.hasShips(new int[]{topRightX, topRightY}, new int[]{bottomLeftX, bottomLeftY}
        if (bottomLeftX == topRightX && bottomLeftY == topRightY) {
            return 1;
        }

        // 分治法，不管怎么样都一分为二
        int midX = (bottomLeftX + topRightX) >>> 1;
        int midY = (bottomLeftY + topRightY) >>> 1;

        // 左上角
        res += countShips(sea, new int[]{midX, topRightY}, new int[]{bottomLeftX, midY + 1});

        // 右上角
        res += countShips(sea, new int[]{topRightX, topRightY}, new int[]{midX + 1, midY + 1});

        // 右下角
        res += countShips(sea, new int[]{topRightX, midY}, new int[]{midX + 1, bottomLeftY});

        // 左下角
        res += countShips(sea, new int[]{midX, midY}, new int[]{bottomLeftX, bottomLeftY});
        return res;
    }
}