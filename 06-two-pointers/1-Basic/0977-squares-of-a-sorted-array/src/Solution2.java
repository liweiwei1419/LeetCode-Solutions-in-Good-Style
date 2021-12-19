public class Solution2 {

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];

        // 从后向前赋值，平方值最大的数只能出现在输入数组的头和尾
        int index = len - 1;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (A[left] * A[left] > A[right] * A[right]) {
                res[index] = A[left] * A[left];
                left++;
            } else {
                res[index] = A[right] * A[right];
                right--;
            }
            index--;
        }
        return res;
    }
}