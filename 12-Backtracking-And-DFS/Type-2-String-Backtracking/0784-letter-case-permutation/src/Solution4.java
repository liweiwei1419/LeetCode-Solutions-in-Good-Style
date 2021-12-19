import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(S, 0, len, path, res);
        return res;
    }

    private void dfs(String S, int index, int len, StringBuilder path , List<String> res) {
        if (index == len) {
            res.add(path.toString());
            return;
        }

        path.append(S.charAt(index));
        dfs(S, index + 1, len, path, res);
        path.deleteCharAt(path.length() - 1);

        if (Character.isLetter(S.charAt(index))) {
            path.append((char) (S.charAt(index) ^ (1 << 5)));
            dfs(S, index + 1, len, path, res);
            path.deleteCharAt(path.length() - 1);

        }
    }
}