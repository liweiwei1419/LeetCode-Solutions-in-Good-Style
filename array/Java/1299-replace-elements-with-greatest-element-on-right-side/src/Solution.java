import java.util.Arrays;

public class Solution {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] minRight = new int[len];

        minRight[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            minRight[i] = Math.max(minRight[i + 1], arr[i + 1]);
        }

        minRight[len - 1] = -1;
        return minRight;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        Solution solution = new Solution();
        int[] res = solution.replaceElements(arr);
        System.out.println(Arrays.toString(res));
    }


}
