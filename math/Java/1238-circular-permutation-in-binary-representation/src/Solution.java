import java.util.ArrayList;
import java.util.List;


/**
 * @author liweiwei1419
 * @date 2019/11/2 5:03 下午
 */
public class Solution {


    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }

        int index = 0;
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            if (res.get(i) == start) {
                index = i;
                break;
            }
        }

        reverse(res, 0, index - 1);
        reverse(res, index, size - 1);
        reverse(res, 0, size - 1);
        return res;
    }

    private void reverse(List<Integer> res, int left, int right) {
        while (left < right) {
            swap(res, left, right);
            left++;
            right--;
        }
    }

    private static void swap(List<Integer> res, int i, int j) {
        Integer tmp = res.get(i);
        res.set(i, res.get(j));
        res.set(j, tmp);
    }

    public static void main(String[] args) {
        int n = 2;
        int start = 3;
        Solution solution = new Solution();
        List<Integer> res = solution.circularPermutation(n, start);
        System.out.println(res);
    }
}
