import java.util.Arrays;

public class Solution {

    public void hanota(int[] A, int[] B, int[] C) {
        int len = A.length;
        System.out.println(len);
        C = new int[len];
        System.out.println(Arrays.toString(C));

        System.arraycopy(A, 0, C, 0, len);
        System.out.println(Arrays.toString(C));


        Arrays.fill(A, 0);
    }

    public static void main(String[] args) {
        int[] A = {0};
        int[] B = {};
        int[] C = {};
        Solution solution = new Solution();
        solution.hanota(A,B,C);
        System.out.println(Arrays.toString(C));
    }
}
