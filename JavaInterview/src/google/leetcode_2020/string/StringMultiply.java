package google.leetcode_2020.string;

public class StringMultiply {

    public static void main(String[] args) {

        String ans = new StringMultiply().multiply("123", "456");
        System.out.println(ans);
    }

    public String multiply(String num1, String num2) {

        if(num1 == null || num2 == null){
            return null;
        }

//        if(num1.equals("0") || num2.equals("0")){
//            return "0";
//        }

        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();


        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n - 1];


        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j>= 0; j--) {

                    // this method takes alot of time
//                int mul =  Character.getNumericValue(nums1[i]) * Character.getNumericValue(nums2[j]);

                // since we know all numbers just substitute with 0.
                int mul =  (nums1[i] - '0') * (nums2[j] - '0');

                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = mul + pos[pos2];
                // sum
                pos[pos1]  += sum/10;
                // carry
                pos[pos2]  = sum%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< pos.length; i++){
//            if(!(sb.length() == 0 && pos[i] ==0)){
                sb.append(pos[i]);
//            }
        }

        while(sb.length() != 0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
