import java.util.Arrays;

public class Solution3 {

    public void merge(int[] A, int m, int[] B, int n) {
        // 即使只有一行语句，也要把括号加上，在这题虽然没有必要
        // 这应该是养成习惯的，以后内容如果有扩展，很可能会造成一个不易被察觉的 bug
        if (m == 0) {
            System.arraycopy(B, 0, A, 0, n);
        }

        int pa = m - 1;
        int pb = n - 1;
        int i = A.length - 1;
        while (pa >= 0 && pb >= 0) {
            // 把 while 循环里一开始就判断 if (pa == 0) 和 else if (pb == 0) 的部分挪到 while 外面
            // 在内层循环可以少掉一些判断

            if (A[pa] > B[pb]) {
                A[i] = A[pa];
                // 自减独占一行，依然是为了增强可读性，方便调试
                // 非常不建议写 A[i--] 这种代码
                // 原来的写的 A[i--] = A[pa]; 和 A[i--] = B[pb];
                // 后面直接就 break 掉了，A[i--] 里面的 i-- 根本不会被执行
                pa--;
            } else {
                A[i] = B[pb];
                pb--;
            }

            // 每一轮循环覆盖数组 A 里面的一个值
            i--;
        }

        // 如果数组 A 的值全部看完了，直接把数组 B 里没有看完的值赋值到数组 A
        if (pa == -1) {
            System.arraycopy(B, 0, A, 0, pb + 1);
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 0};
        int m = 1;
        int[] B = {1};
        int n = 1;

        Solution3 solution3 = new Solution3();
        solution3.merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }
}
