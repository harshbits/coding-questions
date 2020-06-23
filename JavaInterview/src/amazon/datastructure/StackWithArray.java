package amazon.datastructure;

/**
 * The requirements of the stack are: 1) the stack has a constructor which
 * accept a number to initialize its size, 2) the stack can hold any type of
 * elements, 3) the stack has a push() and a pop() method.
 * 
 * I remember there is a similar example in the "Effective Java" book written by
 * Joshua Bloch, but not sure how the example is used. So I just write one and
 * then read the book, and see if I miss anything.
 * 
 * @author hbhavsar
 *
 */
public class StackWithArray<T> {
	private int capacity;
	private T[] array = null;
	private int top = -1;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public StackWithArray(int capacity) {
		this.capacity = capacity;
		this.array = (T[]) new Object[capacity];
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T t = this.array[this.top];
		this.size--;
		// prevent memory leaking
		this.array[top] = null;
		this.top--;
		return t;
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		}
		T t = this.array[this.top];
		return t;
	}

	public T get(int index) {
		return this.array[index];
	}

	public boolean push(T t) {
		if (isFull()) {
			return false;
		}
		this.array[++top] = t;
		this.size++;
		return true;
	}

	public boolean isEmpty() {
		// if(this.size == 0) {
		// return true;
		// }
		// return false;
		return this.size == 0;
	}

	public boolean isFull() {
		// if(this.size == this.capacity) {
		// return true;
		// }
		// return false;
		return this.size == this.capacity;
	}

	public String toString() {
		if (this.size == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++) {
			sb.append(this.array[i] + ", ");
		}
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}
}
