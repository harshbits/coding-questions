package facebook.leetcode_2020.string;

public class StringSimilar {

    public static void main(String[] args) {

        boolean ans = new StringSimilar().areSimilar("face", "eacf");
        System.out.println(ans);
    }

    // O(N) time
    // n = length of a/b

    // Could be improved n/2
    public boolean areSimilar(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        // O(1) constant space
        int totalDiff = 0;
        int[] diffIndices = new int[2];
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (totalDiff > 1) {
                    return false;
                }
                diffIndices[totalDiff++] = i;
            }
        }

        return totalDiff == 0 || (a.charAt(diffIndices[0]) == b.charAt(diffIndices[1])
                && a.charAt(diffIndices[1]) == b.charAt(diffIndices[0]));
    }
}
