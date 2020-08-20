package concurrent.completable;

import javafx.util.Pair;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by mwu on 2020/8/5
 */
public class CompletableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<Pair<Long, Long>> future = CompletableFuture.supplyAsync(() -> {
            int num = 1000000;
            long sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i * i;
            }
            return new Pair<>(sum, System.currentTimeMillis());
        });
        Pair<Long, Long> result = future.get();
        System.out.println(result.getKey());
        System.out.println(result.getValue() - startTime);
    }
}
