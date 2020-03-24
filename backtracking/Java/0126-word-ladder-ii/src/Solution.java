import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 这是 TLE 解
public class Solution {




    public static void main(String[] args) {
        // write your code here
        // write your code here

//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
//
//
//        Solution solution = new Solution();
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


//        String[] words ={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//        List<String> wordList = new ArrayList<>();
//
//        for(String word:words){
//            wordList.add(word);
//        }
//        Solution solution = new Solution();
//        String beginWord = "qa";
//        String endWord = "sq";
//        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
//        System.out.println(res);


        String[] words = {"rex", "ted", "tex", "tad", "tax"};
        List<String> wordList = new ArrayList<>();

        for (String word : words) {
            wordList.add(word);
        }
        Solution solution = new Solution();
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);

    }
}
