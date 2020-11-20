public class Solution6 {

    public int findBestValue(int[] arr, int target) {
        int l = -1;
        int r = target;
        int n = arr.length;
        int diff = Integer.MAX_VALUE;
        int res = 0;

        while (l + 1 < r) {
            int m = (l + r) / 2;
            int[] narr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                narr[i] = arr[i];
                if (narr[i] > m) {
                    narr[i] = m;
                }
                sum += narr[i];
            }
            if (Math.abs(sum - target) < diff) {
                res = m;
                diff = Math.abs(sum - target);
            } else if (Math.abs(sum - target) == diff) {
                res = Math.min(res, m);
            }
            if (sum < target) {
                l = m;
            } else {
                r = m;
            }
        }
        return res;
    }
}