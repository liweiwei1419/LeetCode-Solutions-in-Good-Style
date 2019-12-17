import java.util.Stack;

public class Solution {
    // 其实没有想象中那么难，完全可以独立完成，关键是很多情况要考虑到。
    // 但是代码写成这样，这么多 if 也是觉得看着很不舒服
    // 出栈之前一定要判断一下当前的栈是不是空，否则会抛 java.util.EmptyStackException

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String p : paths) {
            if (!stack.isEmpty() && "..".equals(p)) {
                stack.pop();
            }
            if (!"".equals(p) && !".".equals(p) && !"..".equals(p)) {
                stack.push(p);
            }
        }
        // 输出路径字符串
        StringBuilder s = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.empty()) {
            s.insert(0, "/" + stack.pop());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        // String s = "/a/.////b/../../c/";
        String s = "/../";
        String simplifyPath = new Solution().simplifyPath(s);
        System.out.println(simplifyPath);
    }
}