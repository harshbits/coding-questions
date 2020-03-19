package google.leetcode_2020.string;

public class EncodeNumber {

    //https://leetcode.com/discuss/interview-question/453156/Google-or-Onsite-or-Encode-number
/*
Given sequence of numbers from 0 to X, where
0 = 000000,
...,
999_999 = 999999,
1_000_000 = 00000A,
1_000_001 = 00001A,
...,
_ = 99999A,
_ = 00000B,
...,
_ = 00000Z,
_ = 0000AZ
...,
_ = 9ZZZZZ,
_ = AZZZZZ,
...,
X - 1 = YZZZZZ,
X = ZZZZZZ.
Write a function to encode N (from 0 to X) in this format.
*/
    public static void main(String[] args) {
        assert encode(0).equals("000000");
        assert encode(1).equals("000001");
        assert encode(10).equals("000010");
        assert encode(512).equals("000512");
        assert encode(999_999).equals("999999");
        assert encode(1_000_000).equals("00000A");
        assert encode(1_000_000 + 100_000 - 1).equals("99999A");
        assert encode(1_000_000 + 100_000 * 25).equals("00000Z");
        assert encode(1_000_000 + 100_000 * 26 - 1).equals("99999Z");
        assert encode(1_000_000 + 100_000 * 26).equals("0000AZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 - 1).equals("9999ZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 - 1).equals("999ZZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 + 100 * 26 - 1).equals("99ZZZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 + 100 * 26 - 24).equals("76ZZZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 + 100 * 26 + 10 * 26 - 1).equals("9ZZZZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 + 100 * 26 + 10 * 26 + 26 - 2).equals("YZZZZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 + 100 * 26 + 10 * 26 + 26 - 1).equals("ZZZZZZ");
        assert encode(1_000_000 + 100_000 * 26 + 10_000 * 26 + 1_000 * 26 + 100 * 26 + 10 * 26 - 3).equals("7ZZZZZ");
    }

    static String encode(int num) {
        if (num < 1_000_000) {
            String mid = ("" + num);
            StringBuilder head = new StringBuilder();
            while (head.length() + mid.length() < 6) {
                head.append('0');
            }
            String ans = head.append(mid).toString();
            return ans;
        }
        num -= 1_000_000;
        StringBuilder tail = new StringBuilder();
        int tens = 100_000;
        while (tens > 0 && num - 26 * tens >= 0) {
            tail.append('Z');
            num -= 26 * tens;
            tens /= 10;
        }
        tail.append((char) ('A' + num / tens));
        String mid = num % tens > 0 ? "" + (num % tens) : "";
        StringBuilder head = new StringBuilder();
        while (head.length() + mid.length() + tail.length() < 6) {
            head.append('0');
        }
        String ans = head.append(mid).append(tail.reverse()).toString();
        return ans;
    }


//   After giving it some thinking, I observed that
//   the maximum number you can encode with the rightmost character (i.e. 00000Z)
//   is 3500000 which is the result of (10 + 25) * k where k is equal to 100000 initially.
//   In this expression, k is the factor that determines the limit of a
//   number being encoded using letters or digits only.
//   The 10 part of this expression, corresponds to A which is
//   the first non-numeric encoding symbol; 10 + 25 corresponds to Z,
//   the highest-valued encoding letter. Using this, you'll realize that
//   any time that you compute number / k and its result is less than 10,
//   the number won't need letters to be encoded. Otherwise,
//   add the corresponding letter to the rightmost position of your result,
//   subtract the encoded quantity from number,
//   decrease k by a factor of 10 and repeat the process. See my C# solution:

// if the input is explicitly said to be given as a `string` rather than an `int`,
// you can easily parse it into an `int` since the maximum value that can be encoded
// using this procedure is bounded and doesn't exceed `int.MaxValue`

// Feel free to add a check for the edge case when the input exceeds the maximum number
// that can be encoded using this procedure

    public String Encode(int number) {
        var result = new StringBuilder();
        for (var k = 100000; k > 0; k /= 10) {
            var quotient = number / k;
            if (quotient < 10) {
                result.insert(0, number);
                break;
            }
            var c = (char) (Math.min(quotient, 35) - 10 + 'A');
            result.insert(0, c);
            number -= Math.min(quotient, 35) * k;
        }

        while (result.length() < 6) {
            result.insert(0, 0);
        }

        return result.toString();
    }
}


