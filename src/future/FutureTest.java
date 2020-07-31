package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by lideqing@xiaomi.com on 20-5-15
 */
public class FutureTest {

    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", future).start();
        new Client("Client2", future).start();
        System.out.println("waitting");
        //设置Future.get()获取到的值
        future.complete(200);
        //以异常的形式触发计算
        //f.completeExceptionally(new Exception());

    }
}
