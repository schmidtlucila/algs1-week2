import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by lucila on 17/08/17.
 */
public class Permutation {

    public static void main(String[] args) {
        if (args.length  != 0) {
            System.out.println("Poneme un argumento!!!!");
        } else {
            int k = Integer.parseInt(args[0]);
            RandomizedQueue<String> randomized = new RandomizedQueue<>();
            StdOut.println("Enter something:");
            while (! StdIn.isEmpty()) {
                randomized.enqueue(StdIn.readString());
                StdOut.println("Enter something:");
            }
            Iterator<String> iterator = randomized.iterator();
            for (int i = 0; i < k; i++) {
                StdOut.print(iterator.next());
            }

        }
    }

}
