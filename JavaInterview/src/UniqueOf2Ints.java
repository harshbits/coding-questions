import java.util.HashSet;
import java.util.Set;

public class UniqueOf2Ints {

	public static void main(String[] args) {
		// int a = 5;
		// int b = 9;
		//
		// int unique = ((a + b) * (a + b + 1) / 2) + b;
		// System.out.println(unique);
		//
		// a = 9;
		// b = 5;
		//
		// unique = ((a + b) * (a + b + 1) / 2) + b;
		//
		//
		// System.out.println(unique);
		UniqueOf2Ints unq = new UniqueOf2Ints();

		long start = System.currentTimeMillis();
		Set<Integer> set = new HashSet<>();
		// int count = 0;
		for (int i = 0; i < 3999; i++) {
			for (int j = 0; j < 3999; j++) {
				int u = unq.unique(i, j);
				// if(!set.contains(u)) {
				// System.out.println(u +" is unique");
				// }else {
				// System.out.println(u +" is not unique");
				// }
				set.add(u);
				// count++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Total int time: " + (end - start));

		start = System.currentTimeMillis();
		Set<String> set1 = new HashSet<>();
		// int count = 0;
		for (int i = 0; i < 3999; i++) {
			for (int j = 0; j < 3999; j++) {
				String u = i + "->" + j;
				set1.add(u);
			}
		}
		end = System.currentTimeMillis();
		System.out.println("Total string time: " + (end - start));

		start = System.currentTimeMillis();
		Set<String> set2 = new HashSet<>();
		// int count = 0;
		for (int i = 0; i < 3999; i++) {
			for (int j = 0; j < 3999; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(i).append("->").append(j);
				set2.add(sb.toString());
			}
		}
		end = System.currentTimeMillis();
		System.out.println("Total string builder time: " + (end - start));

		// System.out.println(count);
		System.out.println(set.size());
		System.out.println(set1.size());
	}

	int unique(int a, int b) {
		return ((a + b) * (a + b + 1) / 2) + b;
	}
}
