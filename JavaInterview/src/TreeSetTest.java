import java.math.BigDecimal;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {

		BigDecimal b1 = new  BigDecimal("10.000");
		
		BigDecimal b2 = new  BigDecimal("10.00");
		
		System.out.println(b1.compareTo(b2) == 0);
		
		
		
//		TreeSet<Integer> set = new TreeSet<>();
		
		
////		HashMap<;, V>
//		set.add(10);
//		set.add(5);
//		set.add(20);
//		set.add(1);
//		
//		set.forEach(System.out::println);
//	
//		set.add(-1);
//		set.forEach(System.out::println);
		
//		System.out.println(new TreeSetTest().comb(10));
	}
	
	
	
	public int comb(int n) {
		if (n == 1 || n == 2 || n == 3)
			return n;
		return comb(n - 1) + comb(n - 2);
	}
}
