package future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lideqing@xiaomi.com on 20-5-15
 */
public class HandleTest {
    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t) / 1000 + " seconds");
        return rand.nextInt(1000);
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(HandleTest::getMoreData);
        Future<Integer> f = future.handle((v, e) -> {
            System.out.println(v + "_" + e);
            return 1;
        });
        System.out.println("next");
        System.out.println(f.isDone());
        Thread.sleep(10000);
        //设置Future.get()获取到的值
        //以异常的形式触发计算
        //f.completeExceptionally(new Exception());

    }

    public void getClient() {

    }

    class Task extends Thread {

    }
}
