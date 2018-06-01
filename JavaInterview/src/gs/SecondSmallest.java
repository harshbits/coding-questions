package gs;

public class SecondSmallest {

	public static int secondSmallestNumber(int[] x) {
		
		
		//
		// ask what is expected behaviour when xay is null ?
		if(x == null) {
			
		}
		
		// -20000000 can not be part of integer
		
		int min = Integer.MAX_VALUE;
		int secMin = Integer.MAX_VALUE;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < min) {
				secMin = min;
				min = x[i];
			} else if (x[i] < secMin && x[i] != min) {
				secMin = x[i];
			}
		}
		if(secMin == Integer.MAX_VALUE) {
			return min;
		}
		return secMin;
	}
	
	
	static void print2Smallest(int arr[])
    {
        int first, second, arr_size = arr.length;
 
        /* There should be atleast two elements */
        if (arr_size < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }
 
        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than first
              then update both first and second */
            if (arr[i] < first)
            {
                second = first;
                first = arr[i];
            }
 
            /* If arr[i] is in between first and second
               then update second  */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second" +
                               "smallest element");
        else
            System.out.println("The smallest element is " +
                               first + " and second Smallest" +
                               " element is " + second);
    }

	public static void main(String args[]) {
		int x[] = { 1, 1, 1 };
//		print2Smallest(x);
		System.out.println(secondSmallestNumber(x));
	}
}