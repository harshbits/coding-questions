package facebook.leetcode_2020.slidingwindow;

public class BullsAndCows {

    public static void main(String[] args) {
//        String secret = "1807", guess = "7810";
        String secret = "1123", guess = "0111";
        String ans = new BullsAndCows().getHint(secret, guess);
        System.out.println(ans);
    }

    public String getHint(String secret, String guess) {
        StringBuilder ans = new StringBuilder();
        int bulls = 0;
        int cows = 0;

        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (numbers[s] < 0) {
                    cows++;
                }
                if (numbers[g] > 0) {
                    cows++;
                }
                numbers[s]++;
                numbers[g]--;
            }
        }
        return ans.append(bulls).append("A").append(cows).append("B").toString();
    }
}
