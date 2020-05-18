public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
        int len = m + n;
        int i = m - 1;
        int j = n - 1;

        for (int k = len - 1; k >= 0; k--) {
            if (i == -1) {
                System.arraycopy(B, 0, A, 0, j + 1);
                break;
            } else if (j == -1) {
                break;
            } else if (A[i] >= B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j--;
            }
        }
    }
}
