public class Solution2 {

    // 同 Solution

    public boolean checkInclusion(String s1, String s2) {
        int sLen1 = s1.length();
        int sLen2 = s2.length();

        char[] charArray1 = s1.toCharArray();
        int[] cnt1 = new int[128];
        int[] cnt2 = new int[128];

        int distance = 0;
        for (char c : charArray1) {
            if (cnt1[c] == 0) {
                distance++;
            }
            cnt1[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        char[] charArray2 = s2.toCharArray();

        while (right < sLen2) {
            // 两个 continue 都可以不要
            if (cnt1[charArray2[right]] == 0) {
                right++;
                continue;
            }

            cnt2[charArray2[right]]++;
            if (cnt2[charArray2[right]] == cnt1[charArray2[right]]) {
                count++;
            }

            right++;
            while (count == distance) {
                if (right - left == sLen1){
                    return true;
                }

                if (cnt1[charArray2[left]] == 0) {
                    left++;
                    continue;
                }

                cnt2[charArray2[left]]--;
                if (cnt2[charArray2[left]] < cnt1[charArray2[left]]) {
                    count--;
                }
                left++;
            }
        }
        return false;
    }
}