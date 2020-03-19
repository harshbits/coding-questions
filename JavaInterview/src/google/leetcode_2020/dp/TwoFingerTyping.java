package google.leetcode_2020.dp;

public class TwoFingerTyping {


    public static void main(String[] args) {

    }


    //    Time O(N)
    //    Space O(1)
    public int minimumDistance(String word) {

        // But either 2D or 3D, We actually don't really need at all.
        // We only need to record the position of the left finger.

        // dp[a]
        // our left finger ends at character a,
        // the maximum we can save is dp[a].
        int dp[] = new int[26];
        int res = 0;
        int save = 0;
        int n = word.length();

        // a and b are positions of the finger
        // a finger 1
        // b finger 2

        for (int i = 0; i < n - 1; ++i) {
            int b = word.charAt(i) - 'A';
            int c = word.charAt(i + 1) - 'A';
            for (int a = 0; a < 26; ++a) {
                dp[b] = Math.max(dp[b], dp[a] + distance(b, c) - distance(a, c));
            }

            save = Math.max(save, dp[b]);
            res += distance(b, c);
        }
        return res - save;
    }

    // return the distance moving from a to b
    private int distance(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }



    // Using DFS
    int[][][] memo = new int[27][27][300];

    public int minimumDistanceDfs(String word) {
        return minDist(word, 0, null, null);
    }

    private int minDist(String word, int pos, Character c1, Character c2) {
        if (pos >= word.length()){
            return 0;
        }

        int idx1 = c1 == null ? 0 : c1 - 'A' + 1;
        int idx2 = c2 == null ? 0 : c2 - 'A' + 1;
        if (memo[idx1][idx2][pos] == 0) {
            memo[idx1][idx2][pos] = Math.min(getDist(c1, word.charAt(pos)) + minDist(word, pos + 1, word.charAt(pos), c2),
                    getDist(c2, word.charAt(pos)) + minDist(word, pos + 1, c1, word.charAt(pos)));
        }
        return memo[idx1][idx2][pos];
    }

    private int getDist(Character c1, Character c2) {
        if (c1 == null || c2 == null) return 0;
        int d1 = c1 - 'A', d2 = c2 - 'A';
        int x1 = d1 / 6, y1 = d1 % 6;
        int x2 = d2 / 6, y2 = d2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
