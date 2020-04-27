package facebook.leetcode_2020.divideconquer;

public class NumberToWords {

    public static void main(String[] args) {
        int num = 1000;
        String ans = new NumberToWords().numberToWords(num);
        System.out.println(ans);
    }

    // Time = O(N); N = number of digits in num
    // Space = O(1) to store labels
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 20) {
            return LESS_THAN_20[num];
        }
        int i = 0;
        StringBuilder words = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, (dfs(num % 1000) + THOUSANDS[i] + " "));
            }
            num /= 1000;
            i++;
        }
        return words.toString().trim();
    }

    private String dfs(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + dfs(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + dfs(num % 100);
        }
    }

    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

}
