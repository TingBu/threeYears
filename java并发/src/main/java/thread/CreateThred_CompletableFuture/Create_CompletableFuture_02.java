package thread.CreateThred_CompletableFuture;

import utils.SmallUtil;

import java.util.concurrent.CompletableFuture;

/**
 * @author xiams
 * @version 1.0
 * @date 2022/1/31 15:57
 * @email 15555470513@163.com
 */
public class Create_CompletableFuture_02 {
    public static void main(String[] args) {

        /**
         * 连接两个异步任务
         */
        SmallUtil.printTimesAndThreadName("01_小白进入餐厅");
        SmallUtil.printTimesAndThreadName("02_小白点餐  番茄鸡蛋 +  白米饭");

        /**
         * Request：当厨师炒菜 和 服务员打饭 是两个不同的子线程，且是先炒菜再打饭的顺序执行
         */
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName("03_厨师炒菜");
            SmallUtil.sleepMills(100);
            return "04_番茄鸡蛋好了";
        }).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName("05_服务员打饭");
            SmallUtil.sleepMills(100);
            return dish + " && 06_米饭好了";
        }));
        // dish 就是 ‘ return "04_番茄鸡蛋好了"; ’
        SmallUtil.printTimesAndThreadName("07_小白继续打王者");
        SmallUtil.printTimesAndThreadName(String.format("%s,08_小白开始吃饭", cf1.join()));

    }
}
