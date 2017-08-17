import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by lucila on 17/08/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] internal;
    private int availableItems;

    public RandomizedQueue() {
        internal = (Item[]) new Object[]{};
        availableItems = 0;
    }

    public boolean isEmpty() {
        return availableItems == 0;
    }

    public int size() {
        return availableItems;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (availableItems == internal.length) {
            doubleInternal();
        }
        internal[availableItems] = item;
        availableItems++;
    }

    private void doubleInternal() {
        Item[] newInternal = (Item[]) new Object[internal.length];
        for (int i = 0; i < internal.length; i++) {
            newInternal[i] = internal[i];
        }
        internal = newInternal;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (availableItems * 4 < internal.length) {
            halveInternal();
        }
        int randomIndex = StdRandom.uniform(availableItems);
        Item item = internal[randomIndex];
        availableItems--;
        internal[randomIndex] = null;
        return item;
    }

    private void halveInternal() {
        Item[] newInternal = (Item[]) new Object[internal.length / 2];
        for (int i = 0; i < newInternal.length; i++) {
            newInternal[i] = internal[i];
        }
        internal = newInternal;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return internal[StdRandom.uniform(availableItems)];
    }

    public Iterator<Item> iterator() {

        return new Iterator<Item>() {
            private Item[] randomized = randomizedCopy();
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < randomized.length;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = randomized[current];
                current++;
                return item;
            }
        };
    }

    private Item[] randomizedCopy() {
        Item[] copy = (Item[]) new Object[availableItems];
        for (int i = 0; i < availableItems; i++) {
            copy[i] = internal[i];
        }

        StdRandom.shuffle(copy);
        return copy;
    }

    public static void main(String[] args) {

        System.out.println("asdfadsfasdf");    }
}