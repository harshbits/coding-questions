package facebook.leetcode_2020.string;


// Keep a buffer of size 4 as a class variable, call it prevBuf.

// Whenever we call read(n), read from prevBuf first until all characters in prevBuf are consumed
// (to do this, we need 2 more int variables prevSize and prevIndex,
// which tracks the actual size of prevBuf and the index of next character to read from prevBuf).
// Then call read4 to read characters into prevBuf.

// The code is quite clean I think.
public class Reader4 {

    // it reads 4 character at time
    private char[] prevBuf = new char[4];

    private int prevSize = -1;

    private int prevIndex = 0;

    public int read(char[] buf, int n) {

        int count = 0;

        while (count < n && prevSize != 0) {
            // add until we fill all data until previous is read.
            if (prevIndex < prevSize) {
                buf[count++] = prevBuf[prevIndex++];
                continue;
            }
            prevSize = read4(prevBuf);
            prevIndex = 0;
        }
        return count;
    }

    private int read4(char[] buf) {
        return 1;
    }

}
