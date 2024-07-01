package sufixAutomaton;

import java.util.List;

public class SuffixAutomatonPatternMatching {
    public static void main(String[] args) {
        String text = "ababab";
        String pattern = "ab";

        SuffixAutomaton suffixAutomaton = new SuffixAutomaton(text);
        List<Integer> occurrences = suffixAutomaton.findOccurrences(pattern);

        System.out.println("Occurrences of '" + pattern + "' in '" + text + "': " + occurrences);
    }
}
