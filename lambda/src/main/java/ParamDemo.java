import lambda_interface.Param0;
import lambda_interface.Param1;
import lambda_interface.Param2;

public class ParamDemo {
    public static void main(String[] args) {

        Param0 param0 = ()-> System.out.println("I am parm0");

        Param1 param1 = System.out::println;

        Param2 param2 = (message1, message2)-> System.out.println(message1 + message2);



        param0.sayMessage();
        param1.sayMessage("Hello world!");
        param2.sayMessage("Hello world!","Hello runoob!");
    }
}