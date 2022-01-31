package thread.CreateThred_CompletableFuture;

import utils.SmallUtil;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @author xiams
 * @version 1.0
 * @date 2022/1/31 15:57
 * @email 15555470513@163.com
 */
public class Create_CompletableFuture_01 {
    public static void main(String[] args) {

        SmallUtil.printTimesAndThreadName("01_小白进入餐厅");
        SmallUtil.printTimesAndThreadName("02_小白点餐  番茄鸡蛋 +  白米饭");
//        SmallUtil.printTimesAndThreadName("06_小白在打王者");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            SmallUtil.printTimesAndThreadName("03_厨师炒菜");
            SmallUtil.sleepMills(400);
            SmallUtil.printTimesAndThreadName("04_厨师打饭");
            SmallUtil.sleepMills(100);
            return "05_番茄鸡蛋 和  白米饭 好了";
        });

        SmallUtil.printTimesAndThreadName("08_小白继续打王者");
        SmallUtil.printTimesAndThreadName(String.format("%s,07_小白开始吃饭",cf1.join()));

    }
}
