package lambda_interface;

import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {


        Comparator<Integer> comparator = (a1, a2)->{
            return a1-a2;
        };
        System.out.println(comparator.compare(1, 2));
    }
}
