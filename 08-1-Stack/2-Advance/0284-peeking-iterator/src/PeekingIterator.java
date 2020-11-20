import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    private Integer peek = null;

    private boolean peeked = false;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peeked) {
            return peek;
        } else {
            peeked = true;
            peek = iterator.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peeked) {
            peeked = false;
            return peek;
        } else {
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        return peeked || iterator.hasNext();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
        Integer peek1 = peekingIterator.peek();
        System.out.println(peek1);

        Integer peek2 = peekingIterator.peek();
        System.out.println(peek2);

        Integer peek3 = peekingIterator.peek();
        System.out.println(peek3);

        Integer peek4 = peekingIterator.peek();
        System.out.println(peek4);

        Integer next1 = peekingIterator.next();
        System.out.println(next1);

        Integer peek5 = peekingIterator.peek();
        System.out.println(peek5);

        Integer next2 = peekingIterator.next();
        System.out.println(next2);
        Integer next3 = peekingIterator.next();
        System.out.println(next3);
    }
}