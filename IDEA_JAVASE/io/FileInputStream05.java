package IdeaProjects.javase.chapter23.src.com.bjpowernode.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
最终版，需要掌握
 */
public class FileInputStream05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("tempfile");
            //准备一个byte数组
            byte[] bytes = new byte[4];
            /*while (true){
                int readCount = fis.read(bytes);
                if (readCount == -1 ){
                    break;
                }
                //把byte数组转换成字符串，读到多少个转换多少个
                System.out.println(new String(bytes,0,readCount));
            }*/
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1){
                System.out.println(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
