import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        GFG gfg = new GFG();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(strs[j]);
            }

            int res = gfg.lengthOfLIS(nums, n);
            System.out.println(res);
        }
    }

    public int lengthOfLIS(int[] nums, int n) {
        if (n < 2) {
            return n;
        }

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[n];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > tail[end]) {
                end++;
                tail[end] = nums[i];
                continue;
            }

            int left = 0;
            int right = end;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tail[left] = nums[i];
        }

        // 返回的是有效数组的长度，所以是最后一个下标 + 1
        end++;
        return end;
    }
}
