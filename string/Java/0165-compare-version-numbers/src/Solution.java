public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        int ver1len = v1Arr.length;
        int ver2len = v2Arr.length;
        int maxLen = Math.max(ver1len, ver2len);
        for (int i = 0; i < maxLen; i++) {
            int v1 = 0;
            int v2 = 0;
            if (i < ver1len) {
                v1 = Integer.parseInt(v1Arr[i]);
            }
            if (i < ver2len) {
                v2 = Integer.parseInt(v2Arr[i]);
            }
            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String version1 = "1";
        String version2 = "1.1";

        Solution solution = new Solution();
        int compareVersion = solution.compareVersion(version1, version2);
        System.out.println(compareVersion);
    }
}