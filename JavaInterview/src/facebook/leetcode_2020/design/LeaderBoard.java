package facebook.leetcode_2020.design;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoard {

    public static void main(String[] args) {
        LeaderBoard leaderboard = new LeaderBoard();
        leaderboard.addScore(1, 13);
        leaderboard.addScore(2, 93);
        leaderboard.addScore(3, 84);
        leaderboard.addScore(4, 6);
        leaderboard.addScore(5, 89);
        leaderboard.addScore(6, 31);
        leaderboard.addScore(8, 1);
        leaderboard.addScore(9, 98);
        leaderboard.addScore(10, 42);
        System.out.println(leaderboard.top(5));
        leaderboard.reset(1);
        leaderboard.reset(2);
        leaderboard.addScore(3, 76);
        leaderboard.addScore(4, 68);
        System.out.println(leaderboard.top(1));
        leaderboard.reset(3);
        leaderboard.reset(4);
        leaderboard.addScore(2, 70);
        leaderboard.reset(2);
    }

    // Space: O(N) + O(N)
    private TreeMap<Integer, Integer> scores;

    private Map<Integer, Integer> players;

    public LeaderBoard() {
        // Max Heap
        this.scores = new TreeMap<>(Collections.reverseOrder());
        this.players = new HashMap<>();
    }

    // Time: O(1) + O(log N)
    public void addScore(int playerId, int score) {
        if (!players.containsKey(playerId)) {
            players.put(playerId, score);
            scores.put(score, scores.getOrDefault(score, 0) + 1);
        } else {
            int preScore = players.get(playerId);
            int newScore = score + preScore;

            players.put(playerId, newScore);

            int prePlayers = scores.get(preScore);
            // if there's only 1 player with similar score than remove it.
            if (prePlayers == 1) {
                scores.remove(preScore);
            } else {
                // remove total # of players
                scores.put(preScore, prePlayers - 1);
            }
            // update or add new player
            scores.put(newScore, scores.getOrDefault(newScore, 0) + 1);
        }
    }

    //Time: O(K log N)
    public int top(int K) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            int score = entry.getKey();
            int totalPlayers = entry.getValue();
            // so it wont overflow the K
            int n = Math.min(totalPlayers, K);
            ans += (n * score);
            K -= n;
            if (K == 0) {
                break;
            }
        }
        return ans;
    }

    // Time: O(log N)
    public void reset(int playerId) {
        int score = players.get(playerId);
        players.remove(playerId);
        int totalPlayers = scores.get(score);
        // if there's only 1 player with similar score than remove it.
        if (totalPlayers == 1) {
            scores.remove(score);
        } else {
            scores.put(score, totalPlayers - 1);
        }
    }
}
