public class Solution2 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            return s.length() == 0;
        }

        boolean firstMatch = s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 1 && p.charAt(1) == '*'){
            if (isMatch(s, p.substring(2))){
                return true;
            }
            return firstMatch && isMatch(s.substring(1), p);
        }
        return  firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
