package google.leetcode_2020.string;

public class LicenseKeyFormatting {


    public static void main(String[] args) {


//        char c = 'z';
//        c = (char) (c - 'a' + 'A');
//        System.out.println(c);

        String ans = new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4);
        System.out.println(ans);

        ans = new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2);
        System.out.println(ans);
    }


    public String licenseKeyFormatting(String S, int K) {

        char dash = '-';
        int current = 0;
        char[] sc = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = sc[i];
            if (c != dash) {
                if (current % K == 0) {
                    sb.append(dash);
                }
                sb.append(c);
                current++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
