package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static void main(String[] args) {
        ExpressionAddOperators e = new ExpressionAddOperators();
        var ans = e.addOperators("123", 6);
        System.out.println(ans);
    }

    private final static char PLUS = '+';
    private final static char MINUS = '-';
    private final static char MUL = '*';

    // Time: O(N×4 ^ N); n = length of num.
    // There are n-1 slots for us to add an operator
    // and there are 4 choices (+, -, * and no operator) so the complexity is 4^(N-1).
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(num, target, new StringBuilder(), 0, 0, 0, result);
        return result;
    }

    // evaluation is our currenct calculation
    // multiplied keep track of multiplication
    private void dfs(String num, int target, StringBuilder path, int pos, long evaluation, long multiplied, List<String> result) {
        // closing conditions
        if (pos == num.length()) {
            if (evaluation == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {

            // corner case: if current position is 0, we can only use it as a single digit number, should be 0
            // if it is not a single digit number with leading 0, it should be considered as an invalid number
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            // current number
            long current = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            // position 0 should be considered individually,
            // since it does not have any operand character before curNum
            if (pos == 0) {
                dfs(num, target, path.append(current), i + 1, current, current, result);
                path.setLength(len);
            } else {
                dfs(num, target, path.append(PLUS).append(current), i + 1, evaluation + current, current, result);
                //backtrack
                path.setLength(len);

                dfs(num, target, path.append(MINUS).append(current), i + 1, evaluation - current, -current, result);
                // backtrack
                path.setLength(len);

                // for ex: 1 + 2 + 3 * 4  => 1 + 2 + 3 - 3 + (3 * 4)
                long eval = evaluation - multiplied + multiplied * current;
                dfs(num, target, path.append(MUL).append(current), i + 1, eval, multiplied * current, result);
                // backtrack
                path.setLength(len);
            }
        }
    }
}
