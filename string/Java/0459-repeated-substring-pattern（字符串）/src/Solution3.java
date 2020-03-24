/**
 * 不好理解，但是代码看上去很酷
 *
 * @author liwei
 * @date 18/7/1 下午4:11
 */
public class Solution3 {

    public boolean repeatedSubstringPattern3(String s) {
        // 掐头去尾只要包含就可以了
        return ((s + s).substring(1, 2 * s.length() - 1).contains(s));
    }
}
