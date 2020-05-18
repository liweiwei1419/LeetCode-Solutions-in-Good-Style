import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<int[]> res = new ArrayList<>();

    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[1][];
        }

        int left = 1;
        int right = 2;
        int curSum = left;

        int mid = (left + target) >>> 1;

        while (left < mid) {

            curSum += right;
            right++;

            if (curSum == target) {
                res.add(sum(left, right));
            }

            while (curSum > target) {
                curSum -= left;
                left++;
                if (curSum == target) {
                    res.add(sum(left, right));
                }
            }
        }

        return res.toArray(new int[0][]);
    }

    private int[] sum(int left, int right) {

        int length = right - left;
        int i = 0;
        int[] nums = new int[length];

        while (i < length) {
            nums[i] = i + left;
            i++;
        }

        return nums;
    }

}
