import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        set.addAll(dict);
        StringBuilder stringBuilder = new StringBuilder();

        String[] words = sentence.split(" ");
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                if (set.contains(prefix)) {
                    words[i] = prefix;
                    break;
                }
            }
            stringBuilder.append(words[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> dict = Arrays.asList(new String[]{"cat", "bat", "rat"});
        String sentence = "the cattle was rattled by the battery";
        String replaceWords = solution2.replaceWords(dict, sentence);
        System.out.println(replaceWords);
    }
}
