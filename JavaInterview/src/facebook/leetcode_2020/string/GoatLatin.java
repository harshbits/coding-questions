package facebook.leetcode_2020.string;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        String ans = new GoatLatin().toGoatLatin(s);
        System.out.println(ans);
    }

    private static final Set<Character> VOWELS = new HashSet<>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    private static final char LOWER_A = 'a';

    private static final char SPACE = ' ';

    private static final String MA = "ma";

    //Time: O(N^2)
    //Space:  O(N^2)
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        int wordIndex = 0;

        for (String s : S.split("\\s")) {
            wordIndex++;
            if (VOWELS.contains(s.charAt(0))) {
                sb.append(s);
            } else {
                sb.append(s.substring(1));
                sb.append(s.charAt(0));
            }
            sb.append(MA);
            // Appends a
            for (int i = 0; i < wordIndex; i++) {
                sb.append(LOWER_A);
            }
            sb.append(SPACE);
        }
        return sb.toString().trim();
    }
}
