package facebook.leetcode_2020.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Curent                 Change            Output
 * <p>
 * /                    /facebook           /facebook
 * /facebook/anin       ../abc/def          /facebook/abc/def
 * /facebook/instagram   ../../../../.      /
 */
public class SimplifyPathII {

    public static void main(String[] args) {

        SimplifyPathII s = new SimplifyPathII();

        String current1 = "/";
        String change1 = "/facebook ";
        System.out.println(s.simplifyPath(current1, change1)); //ans: /facebook

        String current2 = "/facebook/anin";
        String change2 = "../abc/def";
        System.out.println(s.simplifyPath(current2, change2)); //ans: /facebook/abc/def

        String current3 = "/facebook/instagram";
        String change3 = "../../../../.";
        System.out.println(s.simplifyPath(current3, change3)); //ans: /
    }

    private static final String CURRENT_DIRECTORY = ".";

    private static final String PREVIOUS_DIRECTORY = "..";

    private static final String SEPARATOR = "/";

    // Time: O(N + M) (N = current Length, M = change Length)
    // Space: O(N + M)
    public String simplifyPath(String current, String change) {
        if (change == null || change.trim().isEmpty()) {
            return current;
        }

        Deque<String> stack = new ArrayDeque<>();
        // O(N)
        String[] currentComponents = current.split(SEPARATOR);
        // O(Directory Size) <= O(N)
        // Assuming directory is normal
        for (String directory : currentComponents) {
            if (!directory.isEmpty()) {
                stack.push(directory);
            }
        }
        String[] changeComponents = change.split("/");

        // O(Directory Size) <= O(N)
        for (String directory : changeComponents) {
            // current directory . or empty directory
            if (directory.isEmpty() || directory.equals(CURRENT_DIRECTORY)) {
                continue;
            }

            // Previous directory ..
            if (directory.equals(PREVIOUS_DIRECTORY)) {
                // if stack is not empty then go to previous directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(directory);
            }
        }

        // O(Directory Size) <= O(N)
        StringBuilder path = new StringBuilder();
        // reverse sequential order
        Iterator<String> itr = stack.descendingIterator();
        while (itr.hasNext()) {
            path.append(SEPARATOR);
            path.append(itr.next());
        }
        return path.length() > 0 ? path.toString() : SEPARATOR;
    }
}
