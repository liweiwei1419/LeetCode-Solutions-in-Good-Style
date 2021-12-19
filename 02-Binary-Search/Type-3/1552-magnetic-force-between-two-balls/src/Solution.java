import java.util.Arrays;

public class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int left = 1;
        int right = position[len - 1] - position[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (countSplits(position, mid) >= m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int countSplits(int[] position, int distance) {
        int len = position.length;
        int pre = position[0];
        int M = 1;
        for (int i = 1; i < len; i++) {
            if (position[i] - pre >= distance) {
                M++;
                pre = position[i];
            }
        }
        return M;
    }
}