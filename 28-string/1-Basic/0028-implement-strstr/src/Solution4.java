import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public int strStr(String haystack, String needle) {
        int base = 2333;
        int p = 1_000_000_007;
        int n = haystack.length();
        int m = needle.length();
        if (n < m) {
            return -1;
        }

        long hashA = 0;
        long hashB = 0;
        long baseTop = 1;
        for (int i = 0; i < m; i++) {
            hashA = (hashA * base + haystack.charAt(i) - 'a') % p;
            hashB = (hashB * base + needle.charAt(i) - 'a') % p;
            if (i > 0) {
                baseTop = baseTop * base % p;
            }
        }
        if (hashA == hashB) {
            return 0;
        }
        for (int i = m; i < n; i++) {
            int top = (int) (baseTop * (haystack.charAt(i - m) - 'a') % p);
            hashA = ((hashA - top + p) * base + haystack.charAt(i) - 'a') % p;
            if (hashA == hashB) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(-4 / 5);
        System.out.println(4 / 5);

        List<Integer> res = new ArrayList<>();
    }

}
