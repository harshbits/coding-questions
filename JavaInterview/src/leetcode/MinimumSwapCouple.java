package leetcode;

import java.util.Arrays;

public class MinimumSwapCouple {

	
	 public int minSwapsCouples(int[] row) {
		    int res = 0, N = row.length;
		    
		    int[] ptn = new int[N];    
		    int[] pos = new int[N];
		    
		    for (int i = 0; i < N; i++) {
		        ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
		        pos[row[i]] = i;
		    }
		    
		    System.out.println(Arrays.toString(ptn));
		    System.out.println(Arrays.toString(pos));
		    
		    for (int i = 0; i < N; i++) {
		        for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
			    swap(row, i, j);
			    swap(pos, row[i], row[j]);
			    res++;
			}
		    }
		    
		    return res;
		}

		private void swap(int[] arr, int i, int j) {
		    int t = arr[i];
		    arr[i] = arr[j];
		    arr[j] = t;
		}
	
	
	
//	private class UF {
//        private int[] parents;
//        public int count;
//        UF(int n) {
//            parents = new int[n];
//            for (int i = 0; i < n; i++) {
//                parents[i] = i;
//            }
//            count = n;
//        }
//        
//        private int find(int i) {
//        	
//        	System.out.println(Arrays.toString(parents));
//            if (parents[i] == i) {
//                return i;
//            }
//            parents[i] = find(parents[i]);
//            return parents[i];
//        }
//        
//        public void union(int i, int j) {
//            int a = find(i);
//            int b = find(j);
//            if (a != b) {
//                parents[a] = b;
//                count--;
//            }
//        }
//    }
//    public int minSwapsCouples(int[] row) {
//        int N = row.length/ 2;
//        UF uf = new UF(N);
//        for (int i = 0; i < N; i++) {
//            int a = row[2*i];
//            int b = row[2*i + 1];
//            uf.union(a/2, b/2);
//        }
//        return N - uf.count;
//    }
//	
	
	public static void main(String[] args) {
		
		
		int[] row = { 1, 4, 0, 5, 8, 7, 6, 3, 2, 9 };
		System.out.println(new MinimumSwapCouple().minSwapsCouples(row));

		int[] seats = { 1, 4, 0, 5, 8, 7, 6, 3, 2, 9 };

		int count = 0;
		int n = seats.length;
		// for (int i = 0; i < n; i = i + 2) {
		// int partner = getPartner(seats[i]);
		// for (int j = i + 1; j < n; j++) {
		// if (seats[j] == partner && j != i + 1) {
		// swap(seats, i + 1, j);
		// count++;
		// }
		// }
		// }

		int connected = 0 ;
		for (int i = 0; i < n - 1;) {
			// System.out.println(i);
			int j = i + 1;
			int partner = getPartner(seats[i]);

			if (seats[j] != partner) {
				// System.out.println(seats[i] + "\t" + partner);
				count++;
				i++;
			} else {
				connected++;
				i = i + 2;
			}
		}
//		System.out.println(count - 1);
	}

//	static void swap(int[] a, int index1, int index2) {
//		int[] a1 = a;
//		int temp = a1[index1];
//		a1[index1] = a1[index2];
//		a1[index2] = temp;
//		System.out.println(Arrays.toString(a));
//	}

	public static int getPartner(int sheOrHe) {
		// It's her
		if (sheOrHe % 2 == 0) {
			return sheOrHe + 1;
		}
		// it's him
		else {
			return sheOrHe - 1;
		}
	}

}
