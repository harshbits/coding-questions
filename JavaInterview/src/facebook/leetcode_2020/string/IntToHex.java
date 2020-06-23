package facebook.leetcode_2020.string;

public class IntToHex {

    public static void main(String[] args) {

        System.out.println(toHex(1));
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }

    private static final char[] elements = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static String toHex(int num) {

        if (num >= 0 && num < 16) {
            return String.valueOf(elements[num]);
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int q = num & 15;
            num = (num >>> 4);
            sb.insert(0, elements[q]);
        }
        return sb.toString();
    }
}
