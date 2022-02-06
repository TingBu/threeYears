package thread.CreateThred_CompletableFuture;

import utils.SmallUtil;

import java.util.concurrent.CompletableFuture;

/**
 * @author xiams
 * @version 1.0
 * @date 2022/1/31 15:57
 * @email 15555470513@163.com
 */
public class Create_CompletableFuture_03 {
    public static void main(String[] args) {

        /**
         * 合并异步任务
         */

        SmallUtil.printTimesAndThreadName("01_小白进入餐厅");
        SmallUtil.printTimesAndThreadName("02_小白点餐  番茄鸡蛋 +  白米饭");

        /**
         * Request：服务员先蒸米饭，厨师再炒菜。（两个异步任务同时执行）
         *          厨师炒完菜后，服务员再打米饭
         */
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName("03_厨师炒菜");
            SmallUtil.sleepMills(400);
            return "04_番茄鸡蛋";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName("05_服务员蒸米饭");
            SmallUtil.sleepMills(400);
            return "06_米饭";
        }), (dish, rise) -> {
            SmallUtil.printTimesAndThreadName("07_服务员打饭");
            SmallUtil.sleepMills(100);
            return String.format("%s + && + %s + 好了", dish, rise);
        });
        // dish 就是 ‘ return "04_番茄鸡蛋好了"; ’
        SmallUtil.printTimesAndThreadName("08_小白打王者");
        SmallUtil.printTimesAndThreadName(String.format("%s,09_小白开始吃饭", cf1.join()));

    }
}
