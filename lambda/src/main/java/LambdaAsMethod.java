import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class LambdaAsMethod {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        list.add("AAAAA");
        list.add("BBBBB");
        list.add("CCCCC");
        list.add("DDDDD");

        List<CompletableFuture<String>> collect = list.stream().map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> function(s))).collect(Collectors.toList());

        Thread.sleep(1000);
        System.out.println(collect);





    }

    static String function(String s) {
        if(s == "AAAAA"){
            throw new RuntimeException();
        }
        return s;
    }

}
