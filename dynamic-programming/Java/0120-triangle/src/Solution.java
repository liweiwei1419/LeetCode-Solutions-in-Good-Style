import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) {
            return 0;
        }
        // 注意：这里 len + 1 是为了防止越界
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
            // 每一步观察是不是我们想要的，这是调试的重要方法
            // System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> step1 = generateIntegerList(new int[]{2});
        List<Integer> step2 = generateIntegerList(new int[]{3, 4});
        List<Integer> step3 = generateIntegerList(new int[]{6, 5, 7});
        List<Integer> step4 = generateIntegerList(new int[]{4, 1, 8, 3});


        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(step1);
        triangle.add(step2);
        triangle.add(step3);
        triangle.add(step4);
        int minimumTotal = solution.minimumTotal(triangle);
        System.out.println(minimumTotal);
    }

    private static List<Integer> generateIntegerList(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        return arr;
    }
}
