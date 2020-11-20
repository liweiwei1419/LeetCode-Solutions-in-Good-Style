public class Solution3 {

    // 使用计数排序（不保证稳定性）

    public String frequencySort(String s) {
        int len = s.length();
        int[] count = new int[128];
        int bucketLen = 1;
        for (int sChar : s.toCharArray()) {
            count[sChar] += 1;
            if (count[sChar] > bucketLen) {
                bucketLen = count[sChar];
            }
        }
        StringBuilder[] bucket = new StringBuilder[bucketLen + 1];

        for (int i = 0; i < 128; i++) {
            if (count[i] > 0) {
                if (bucket[count[i]] == null) {
                    bucket[count[i]] = new StringBuilder();
                }
                bucket[count[i]].append((char) i);
            }
        }

        // System.out.println(Arrays.toString(bucket));
        StringBuilder res = new StringBuilder(len);
        for (int i = bucketLen; i > 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i].toString().toCharArray()) {
                    for (int j = 0; j < i; j++) {
                        res.append(c);
                    }
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "cccaaa";
        String res = solution3.frequencySort(s);
        System.out.println(res);
    }
}