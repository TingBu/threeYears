package 测试案例;

import java.io.File;

/**
 * @author xiams
 * @version 1.0
 * @date 2022/2/7 15:28
 * @email 15555470513@163.com
 */
public class FileRenameTest {
    public static void main(String[] args) {

//        File songList = new File("C:\\Users\\TingBu\\Desktop\\x2");
        File songList = new File("D:\\2.S8\\song");
        long fileLength = songList.length();
        String[] files = songList.list();
        if (songList.exists() && files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }

/*        if (songList.exists() && files != null) {
            for (String file : files) {
                if (file != null) {
                    String substring = file.substring(0, file.lastIndexOf("-"));
                    String type = file.substring(file.length() - 4);
                    String newFileName = substring + type;
                    String lastName = file.replace(file, newFileName);
                    System.out.println(lastName);
                }
            }
        }*/

    }
}
