package leetcode.uber;

public class ArrayIsValidPreorderBST {
	
	public static void main(String[] args) {

		int[] tree = { 5, 3, 2, 4, 7, 6, 8 };
		boolean ans = new ArrayIsValidPreorderBST().isValidPreOrderBST(tree);
		System.out.println(ans);
	}

	public boolean isValidPreOrderBST(int[] tree) {

//		if(tree == null || tree.length ==0) {
//			return true;
//		}
		int root = tree[0];
		int index = 1;

		// all left nodes
		while (tree[index] > root) {
			index++;
		}

		for (int i = index; i < tree.length; i++) {
			if (tree[index] < root) {
				return false;
			}
		}

		return true;
	}
}
