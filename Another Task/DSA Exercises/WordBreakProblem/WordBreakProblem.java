package dsaPrograms.WordBreakProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

    public static void main(String[] args) {
        String input1 = "ilikesamsungmobile";
        String[] dictionary1 = {"i", "like", "sam", "sung", "mobile"};

        System.out.println("Word break for \"" + input1 + "\": " + wordBreak(input1, new HashSet<>(Arrays.asList(dictionary1))));

        String input2 = "ilikeicecreamandmango";
        String[] dictionary2 = {"i", "like", "ice", "cream", "and", "man", "go"};

        System.out.println("Word break for \"" + input2 + "\": " + wordBreak(input2, new HashSet<>(Arrays.asList(dictionary2))));
    }

    private static boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    private static boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
        int n = s.length();

        if (start == n) {
            return true;
        }

        for (int end = start + 1; end <= n; end++) {
            String substring = s.substring(start, end);

            if (wordDict.contains(substring) && wordBreakHelper(s, wordDict, end)) {
                return true;
            }
        }

        return false;
    }
}
