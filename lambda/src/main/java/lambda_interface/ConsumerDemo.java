package lambda_interface;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer1 = (s)-> System.out.println(s);
        Consumer<String> consumer2 = (s)-> System.out.println(s+s);
        Consumer<String> consumer3 = (s)-> System.out.println(s+s+s);


        Consumer<String> stringConsumer = consumer1.andThen(consumer2).andThen(consumer3);

        stringConsumer.accept("123");

        consumer1.accept("123");
        consumer2.accept("123");


    }








}
