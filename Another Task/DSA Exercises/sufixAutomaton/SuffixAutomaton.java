package sufixAutomaton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SuffixAutomaton {
    private static final int ALPHABET_SIZE = 26;

    private int[][] transitions;
    private int[] link, length;
    private int size, last;

    public SuffixAutomaton(String text) {
        int maxLength = 2 * text.length();
        transitions = new int[maxLength][ALPHABET_SIZE];
        link = new int[maxLength];
        length = new int[maxLength];
        Arrays.fill(link, -1);
        size = 1;
        last = 0;

        // Build the suffix automaton
        for (char c : text.toCharArray()) {
            extendAutomaton(c - 'a');
        }
    }

    private void extendAutomaton(int c) {
        int cur = size++;
        length[cur] = length[last] + 1;

        int p;
        for (p = last; p != -1 && transitions[p][c] == 0; p = link[p]) {
            transitions[p][c] = cur;
        }

        if (p == -1) {
            link[cur] = 0;
        } else {
            int q = transitions[p][c];
            if (length[p] + 1 == length[q]) {
                link[cur] = q;
            } else {
                int clone = size++;
                length[clone] = length[p] + 1;
                link[clone] = link[q];
                System.arraycopy(transitions[q], 0, transitions[clone], 0, ALPHABET_SIZE);
                link[q] = link[cur] = clone;

                for (; p != -1 && transitions[p][c] == q; p = link[p]) {
                    transitions[p][c] = clone;
                }
            }
        }

        last = cur;
    }

    public List<Integer> findOccurrences(String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int currentState = 0;

        for (int i = 0; i < pattern.length(); i++) {
            int c = pattern.charAt(i) - 'a';

            if (transitions[currentState][c] != 0) {
                currentState = transitions[currentState][c];
            } else {
                while (currentState != 0 && transitions[currentState][c] == 0) {
                    currentState = link[currentState];
                }

                if (transitions[currentState][c] != 0) {
                    currentState = transitions[currentState][c];
                }
            }

            int tempState = currentState;
            while (tempState != 0) {
                occurrences.add(i - length[tempState] + 1);
                tempState = link[tempState];
            }
        }

        return occurrences;
    }
}
