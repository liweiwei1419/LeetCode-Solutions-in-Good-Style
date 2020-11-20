import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        if (dirs.length == 0) {
            return "/";
        }

        Deque<String> stack = new ArrayDeque<>();
        for (String dir : dirs) {
            if ("".equals(dir) || ".".equals(dir)) {
                continue;
            }

            if ("..".equals(dir)) {
                // 注意：只有栈非空的时候才能弹出，注意下面 continue; 的作用
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
                continue;
            }
            stack.addLast(dir);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()) {
            stringBuilder.insert(0, "/");
        }

        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.removeLast());
            stringBuilder.insert(0, "/");
        }
        return stringBuilder.toString();
    }
}