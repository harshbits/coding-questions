package google.leetcode_2020.design;

public class StringIterator {

    public static void main(String[] args) {

        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '

    }

    private char[] compressedChars;

    private Character current;

    private long count;

    private int index;

    private char EMPTY = ' ';

    public StringIterator(String compressedString) {
        this.compressedChars = compressedString.toCharArray();
        this.count = 0;
        this.index = 0;
        this.current = null;
    }

    public char next() {

        if (!hasNext()) {
            return EMPTY;
        }

        if (count == 0) {
            current = compressedChars[index++];

            int i = index;
            while (i < compressedChars.length && Character.isDigit(compressedChars[i])) {
                i++;
            }
            count = Integer.parseInt(new String(compressedChars, index, i - index));
            index = i;
        }
        count--;
        return current;
    }

    public boolean hasNext() {
        // return idx < compressedChars.length() || count !=0;
        return index < compressedChars.length || count > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */