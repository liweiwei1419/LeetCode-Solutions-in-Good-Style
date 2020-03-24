/**
 * 参考资料：https://blog.csdn.net/crazy1235/article/details/51439523
 */
public class Solution2 {

    public int compareVersion(String version1, String version2) {
        int ver1len = version1.length();
        int ver2len = version2.length();
        int v1;
        int v2;
        int i = 0;
        int j = 0;
        while (i < ver1len || j < ver2len) {
            v1 = 0;
            v2 = 0;
            while (i < ver1len && version1.charAt(i) != '.') {
                v1 = v1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;
            while (j < ver2len && version2.charAt(j) != '.') {
                v2 = v2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
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

        Solution2 solution2 = new Solution2();
        int compareVersion = solution2.compareVersion(version1, version2);
        System.out.println(compareVersion);
    }
}