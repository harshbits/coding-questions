package google;

import java.math.BigInteger;

public class Ackermann {
	public static BigInteger ackermann(BigInteger m, BigInteger n) {
		if (m.compareTo(new BigInteger("0")) == 0)
			return n.add(new BigInteger("1"));
		if (n.compareTo(new BigInteger("0")) == 0)
			return ackermann(m.subtract(new BigInteger("1")), new BigInteger("1"));
		return ackermann(m.subtract(new BigInteger("1")), ackermann(m, n.subtract(new BigInteger("1"))));
	}

	public static void main(String[] args) {
//		long M = Long.parseLong(args[0]);
//		long N = Long.parseLong(args[1]);
		long M = 1;
		long N = 2;
		
		System.out.println(ackermann(new BigInteger("4"), new BigInteger("1")));
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
//				System.out.println(ackermann(i, j));
			}
		}
		
	}
}
