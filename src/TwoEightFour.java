import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lideqing@xiaomi.com on 20-3-10
 */
public class TwoEightFour {
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator = null;
        Integer next = null;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (iterator.hasNext()) {
                next = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (next == null) throw new NoSuchElementException();
            int res = next;
            if (iterator.hasNext()) {
                next = iterator.next();
            } else {
                next = null;
            }
            return next;
        }

        @Override
        public boolean hasNext() {
            return next == null;

        }
    }
}
