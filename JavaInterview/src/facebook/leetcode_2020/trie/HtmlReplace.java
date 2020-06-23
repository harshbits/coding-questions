package facebook.leetcode_2020.trie;

import java.util.List;

public class HtmlReplace {

    // doc: <body>Welcome to Facebook</body>
// doc: <body>Welcome to FacebookFacebook</body>
// doc: <body>Welcome to facebook</body>


// substitutions: ['Facebook', 'abc', 'facebook abc']
// output: <body>Welcome to <u>Facebook</u></body>
// output: <body>Welcome to <u>FacebookFacebook</u></body>


// Doc: <body> Facebook hello, there </body>
// Doc: <body> </body>

// Doc: <body>  </body>
// substitutions: ['body']

// Doc: <body> boddyyy  </body>
// substitutions: ['body']

// Doc: <body> <u>Facebook</u> </body> : not possible
// substitutions: ['Facebook']


// Doc: to be
// subs: ['to be', 'o b']
// <u>to be</u>

// Doc: to be or to be
// subs: ['to be', 'o b']
// <u>to be</u> or <u>to be</u>


// Assumtion:  It should be always within body
// Assumtion: no underlined characters

    // Time: O(N) + O(M * Max(S))
// N = doc size
// M = sub list size
    public String function(String doc, List<String> sub) {
        if (sub == null || sub.isEmpty() || doc == null || doc.trim().isEmpty()) {
            return doc;
        }

        // Step 1. Build Trie
        Trie trie = buildTrie(sub);

        // Step 2. Substitute words
        return substitute(doc, trie);
    }

    private static final String ST = "<u>";

    private static final String ED = "</u>";

    // Time: O(N)
    // N = doc size
    private String substitute(String doc, Trie trie) {
        StringBuilder sb = new StringBuilder();
        int n = doc.length();
        int i = 0;

        while (i < n) {
            // check for markdown
            if (doc.charAt(i) == '<') {
                sb.append(doc.charAt(i));
                while (doc.charAt(i) != '>') {
                    sb.append(doc.charAt(i++));
                    i++;
                }
                sb.append(doc.charAt(i));
            }

            // substitute
            if (trie.children[doc.charAt(i)] != null) {
                // can use Strinbuilder
                String word = "" + doc.charAt(i);
                Trie node = trie.children[doc.charAt(i++)];

                while (node.children[doc.charAt(i)] != null) {
                    word += doc.charAt(i);
                    //
                    if (node.isWord) {
                        sb.append(ST).append(word).append(ED);
                        word = null;
                        break;
                    }
                    node = node.children[doc.charAt(i)];
                    i++;
                }

                if (word != null) {
                    sb.append(word);
                }
                i++;
            } else {
                sb.append(doc.charAt(i++));
            }
        }
        return sb.toString();
    }

    // doc: <body>Welcome to <u>Facebook</u></body>
    // Face
    // Facebook

    // Trie
    // O (n * max(len(s))
    private Trie buildTrie(List<String> sub) {
        Trie trie = new Trie();
        for (String word : sub) {
            Trie node = trie;
            for (char c : word.toCharArray()) {
                if (node.children[c] == null) {
                    node.children[c] = new Trie();
                }
                node = node.children[c];
            }
            node.isWord = true;
        }
        return trie;
    }

    class Trie {
        // we can take linked list
        Trie[] children;

        boolean isWord;

        public Trie() {
            this.children = new Trie[256];
            this.isWord = false;
        }
    }
}
