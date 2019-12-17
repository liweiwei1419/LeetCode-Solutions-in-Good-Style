import java.util.Stack;

public class Solution2 {

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        if (dirs.length == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if ("".equals(dir) || ".".equals(dir)) {
                continue;
            }

            if ("..".equals(dir)) {
                if (!stack.empty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(dir);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (stack.empty()) {
            stringBuilder.insert(0, "/");
        }

        while (!stack.empty()) {
            stringBuilder.insert(0, stack.pop());
            stringBuilder.insert(0, "/");
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        // String path = "/a/./b/../../c/";
        // String path = "/home//foo/";
        String path = "/../";
        Solution2 solution2 = new Solution2();
        String res = solution2.simplifyPath(path);
        System.out.println(res);
    }
}
