package facebook.leetcode_2020.design;

public class Buffer {

    public static void main(String[] args) {
        Buffer buf = new Buffer(5); // [. . . . .]
        System.out.println(buf.write(new char[]{'a', 'b', 'c'})); // => 3 [abc . .]
        System.out.println(buf.write(new char[]{'d', 'e', 'f'})); // => 2 because the buffer is full, you can only write two chars [abcde]
        System.out.println(buf.read(3)); // => [abc] [. . . de]
        System.out.println(buf.write(new char[]{'x', 'y', 'z', 'a', 'b', 'c'})); // => 3 [xyzde]
        System.out.println(buf.read(8)); // returns [dexyz] becuase 'de' was written first [. . . . .]
    }

    // Circular array
    private char[] buffer;

    private int head;

    private int tail;

    private int capacity;

    private boolean bufEmpty;

    public Buffer(int capacity) {
        this.buffer = new char[capacity];
        this.capacity = capacity;
        this.bufEmpty = true;
    }

    /**
     * Transfers the content of the given source char array into this buffer.
     * Returns the the number of chars that were written into the buffer.
     */
    public int write(char[] src) {
        int written = 0;
        int srcPtr = 0;
        while (!isFull() && srcPtr < src.length) {
            if (isEmpty()) {
                bufEmpty = false;
            }
            buffer[tail] = src[srcPtr++];
            // update tail
            tail = (tail + 1) % capacity;
            written++;
        }
        return written;
    }

    public char[] read(int n) {
        int read = 0;
        String str = "";
        while (!isEmpty() && read < n) {
            str += buffer[head];
            head = (head + 1) % capacity;
            read++;
            if (isFull()) {
                bufEmpty = true;
            }
        }
        return str.toCharArray();
    }

    // Support methods
    private boolean isEmpty() {
        return tail == head && bufEmpty;
    }

    private boolean isFull() {
        return tail == head && !bufEmpty;
    }
}
