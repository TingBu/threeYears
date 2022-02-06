package thread.CreateThred_CompletableFuture;

import utils.SmallUtil;

import java.util.concurrent.CompletableFuture;

/**
 * @author xiams
 * @version 1.0
 * @date 2022/1/31 15:57
 * @email 15555470513@163.com
 */
public class Create_CompletableFuture_04 {
    public static void main(String[] args) {

        SmallUtil.printTimesAndThreadName("小白吃好了");
        SmallUtil.printTimesAndThreadName("小白要结账");

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName("服务员A 收款25元");
            SmallUtil.sleepMills(100);
            return "25";
        })
                .thenComposeAsync(money -> CompletableFuture.supplyAsync(() -> {
                    SmallUtil.printTimesAndThreadName(String.format("服务员B 开具%s元发票", money));
                    SmallUtil.sleepMills(200);
                    return "%元发票" + money;
                }));
/*                        .thenApplyAsync(money -> CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName(String.format("服务员B 开具%s元发票", money));
            SmallUtil.sleepMills(200);
            return "%元发票" + money;
        }));*/

        SmallUtil.sleepMills(100);
        SmallUtil.printTimesAndThreadName(String.format("小白拿到 %s，准备出门", cf2.join()));
        SmallUtil.printTimesAndThreadName("小白离开了餐厅");
    }
}
