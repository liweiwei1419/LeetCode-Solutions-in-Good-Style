import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution2 {
    public boolean wordPattern(String pattern, String str) {
        boolean wordPattern = false;
        int patternLength = pattern.length();
        String[] strArray = str.split(" ");
        if (patternLength == strArray.length) {

            Map<Character, String> map1 = new HashMap<>();
            Set<String> uniqueValue = new HashSet<>();
            char[] patternArray = pattern.toCharArray();
            for (int i = 0; i < patternLength; i++) {
                if (map1.containsKey(patternArray[i])) {
                    if (!map1.get(patternArray[i]).equals(strArray[i])) {
                        return wordPattern;
                    }
                } else {
                    if (uniqueValue.contains(strArray[i])) {
                        return wordPattern;
                    }
                    uniqueValue.add(strArray[i]);
                    map1.put(patternArray[i], strArray[i]);
                }
            }
            wordPattern = true;
        }
        return wordPattern;
    }
}