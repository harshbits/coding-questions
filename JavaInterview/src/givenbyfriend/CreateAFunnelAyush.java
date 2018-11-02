package givenbyfriend;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * 
 * 
 *  7 8 9 10 11 12 13 1 2 3 4 5 6
 * 
 * 
 * @author habhavsar
 * 
 *         given by Ayush Gupta
 *
 */
public class CreateAFunnelAyush {

	
	
	int[] funnel = new int[15];
	int funnelSize = 0;
	public CreateAFunnelAyush() {
		
	}
	
	public void fill(int... values) {
		if (funnelSize == 0) {
			for (int i = 0; i < values.length; i++) {
				funnel[i] = values[i];
			}
			funnelSize = values.length;
		}
		
		
		
		
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		CreateAFunnelAyush c = new CreateAFunnelAyush();
//
////		c.drip();
////		c.fill('1');
////		c.fill('2');
////		c.fill('3', '4', '5');
////		
////		c.fill('6', '7', '8', '9');
////		
////		c.drip();
////		c.drip();
//		
////		c.fill('0', '1', '2', '3');
//		System.out.println(c.toString());
//
//	}
//
//	private Queue<Character> queue;
//
//	private int funnelMaxSize;
//
////	private int funnelRows;
//
////	private int funnelColumns;
//
//	public CreateAFunnelAyush() {
//		this.queue = new LinkedList<>();
//		this.funnelMaxSize = 15;
////		this.funnelRows = 5;
////		this.funnelColumns = 11;
//
//	}
//
//	public void fill(Character... values) {
//		if (this.queue.size() == this.funnelMaxSize) {
//			throw new RuntimeException("There's no space in funnel.");
//		}
//		if (values == null) {
//			throw new RuntimeException("Invalid fill input.");
//		}
//
//		for (char val : values) {
//			this.queue.add(val);
//		}
//	}
//
//	public Character drip() {
//		return this.queue.poll();
//	}
//
//	@Override
//	public String toString() {
////		Character[][] funnel = new Character[this.funnelRows][this.funnelColumns];
////		// create empty funnel
//////		for (int i = 0; i < funnel.length; i++) {
//////			for (int j = 0; j < funnel[0].length; j++) {
//////				
//////			}
//////		}
////		
////		for (int i = funnel.length - 1; i >= 0; i--) {
////			for (int j = funnel[0].length - 1; j >= 0; j--) {
////				if (i ==  funnel.length - 1) {
////					if (j == 4) {
////						
////					}
////					if (j == 5) {
////						
////					}
////					if (j == 5) {
////						
////					}
////				}
////			}
////		}
//
//		Character[] values = this.queue.toArray(new Character[this.funnelMaxSize]);
//		Arrays.fill(values, this.queue.size(), this.funnelMaxSize, ' ');
//		StringBuilder sb = new StringBuilder();
//		// level 1
//		sb.append("\\").append(values[10]).append(" ").append(values[11]).append(" ").append(values[12]).append(" ")
//				.append(values[13]).append(" ").append(values[14]).append("/").append("\n");
//		// level 2
//		sb.append(" ").append("\\").append(values[6]).append(" ").append(values[7]).append(" ").append(values[8])
//				.append(" ").append(values[9]).append("/").append("\n");
//		// level 3
//		sb.append("  ").append("\\").append(values[3]).append(" ").append(values[4]).append(" ").append(values[5])
//				.append("/").append("\n");
//		// level 4
//		sb.append("   ").append("\\").append(values[1]).append(" ").append(values[2]).append("/").append("\n");
//		// level 4
//		sb.append("    ").append("\\").append(values[0]).append("/").append("\n");
//
//		// level 1
////		sb.append("\\").append(String.join("", Collections.nCopies(9, " "))).append("/").append("\n");
//
//		return sb.toString();
//	}
//
//	
//	
//	Node root;
//	
//	Node last;
//	
//	public void fill(int... values) {
//		if (root == null) {
//			root = new Node(values[0]);
//		}
//		
//		
//	}
//	
//	
//	class Node {
//		
//		Node(int val) {
//			this.val = val;
//		}
//		
//		int val;
//
//		Node left;
//
//		Node right;
//	}

}
