public class Solution3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int r1 = m - 1;
        int r2 = n - 1;
        for (int k = len - 1; k >= 0; k--) {
            if (r1 == -1) {
                nums1[k] = nums2[r2];
                r2--;
            } else if (r2 == -1) {
                nums1[k] = nums1[r1];
                r1--;
            } else if (nums1[r1] >= nums2[r2]) {
                nums1[k] = nums1[r1];
                r1--;
            } else {
                nums1[k] = nums2[r2];
                r2--;
            }
        }
    }
}