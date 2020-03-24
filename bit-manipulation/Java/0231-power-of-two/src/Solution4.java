import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author liwei
 * @date 18/6/30 下午9:54
 */
public class Solution4 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // 比 Integer.MAX_VALUE 小的所有的整数中 2 的方幂的所有的数
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.contains(n);
    }

    // 该 main 方法可以得到整型范围内所有的 2 的方幂
    public static void main(String[] args) {
        int i = 1;
        List<Integer> list = new ArrayList<>();
        while (i > 0 && i < Integer.MAX_VALUE) {
            list.add(i);
            i *= 2;
        }
        System.out.println(list);
    }
}
