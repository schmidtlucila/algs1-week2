import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lucila on 17/08/17.
 */
public class Deque<Item> implements Iterable<Item> {

    private int size;
    private DoubleNode<Item> first;
    private DoubleNode<Item> last;

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Cant add null to Deque");
        DoubleNode<Item> node = new DoubleNode<>(item);
        DoubleNode<Item> oldFirst = first;
        concatenate(node, oldFirst);
        first = node;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Cant add null to Deque");
        DoubleNode<Item> node = new DoubleNode<>(item);
        DoubleNode<Item> oldLast = last;
        concatenate(oldLast, node);
        last = node;
        size++;
    }

    private void concatenate(DoubleNode<Item> first, DoubleNode<Item> second) {
        first.next = second;
        second.previous = first;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        Item removed = first.item;
        first = first.next;
        first.previous = null;
        return removed;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        Item removed = last.item;
        last = last.previous;
        last.next = null;
        return removed;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private DoubleNode<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (! hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        System.out.println("asdfadf");
    }


    private static class DoubleNode<Item> {
        private Item item;
        private DoubleNode<Item> next;
        private DoubleNode<Item> previous;

        private DoubleNode(Item item) {
            this.item = item;
        }

    }
}
