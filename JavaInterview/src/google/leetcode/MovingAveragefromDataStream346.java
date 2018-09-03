package google.leetcode;

/**
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 * 
 * @author hbhavsar
 *
 */
public class MovingAveragefromDataStream346 {
	
	private int size;
	
	private int[] window;
	
	private int currentSize = 0;
	
	private int insert = 0;
	
	private long sum;
	
	public static void main(String[] args) {
		MovingAveragefromDataStream346 m = new MovingAveragefromDataStream346(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
	}
	
	/** Initialize your data structure here. */
    public MovingAveragefromDataStream346(int size) {
        this.size = size;
        this.window = new int[size];
    }
    
    public double next(int val) {
		if (currentSize < size) {
			currentSize++;
		}
		System.out.println("insert 1= > " + insert);
		
		sum -= window[insert];
		sum += val;
		window[insert] = val;
		insert = (insert + 1) % size;
		System.out.println("insert 2= > " + insert);
		return (double) sum / currentSize;
    }
}
