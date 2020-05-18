public class Solution2 {

    // 反面例子

    public void merge(int[] A, int m, int[] B, int n) {
        if (m == 0)
            System.arraycopy(B, 0, A, 0, n);
        int pa = m - 1;
        int pb = n - 1;
        int i = A.length - 1;
        while (pa >= 0 && pb >= 0) {
            if (pa == 0) {
                if (A[pa] < B[pb]) {
                    A[i--] = B[pb--];
                } else {
                    A[i--] = A[pa];
                    System.arraycopy(B, 0, A, 0, pb + 1);
                    break;
                }
            } else if (pb == 0) {
                if (A[pa] > B[pb]) {
                    A[i--] = A[pa--];
                } else {
                    A[i--] = B[pb];
                    break;
                }
            } else if (A[pa] > B[pb]) {
                A[i--] = A[pa--];
            } else {
                A[i--] = B[pb--];
            }
        }
    }
}
