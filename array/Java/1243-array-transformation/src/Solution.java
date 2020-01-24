import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/11/2 10:49 下午
 */
public class Solution {

    public List<Integer> transformArray(int[] arr) {
        int len = arr.length;

        // 默认的语义是有变化
        boolean change = true;

        // 因为 arr[i] 的变化要看它两边的值，如果原地修改，就不符合题意
        // 需要辅助数组
        int[] temp = new int[len];
        while (change) {
            change = false;
            // 因为两边不变，只用复制中间的即可，不能写成 temp = arr;
            System.arraycopy(arr, 1, temp, 1, len - 1);
            for (int i = 1; i < len - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    temp[i]++;
                    change = true;
                }

                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    temp[i]--;
                    change = true;
                }
            }
            // 再复制回去，不能写成 arr = temp;
            System.arraycopy(temp, 1, arr, 1, len - 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {2, 1, 2, 1, 1, 2, 2, 1};
        int[] arr = {1, 6, 3, 4, 3, 5};
        Solution solution = new Solution();
        List<Integer> res = solution.transformArray(arr);
        System.out.println(res);
    }
}
