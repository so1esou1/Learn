package bjpowernode.java.io;

import java.io.FileReader;
import java.util.Properties;

/*
IO和Properties的联合应用
非常好的一个设计理念：
    以后经常改变的数据，可以单独写到一个文件中，使用程序动态读取
    将来只需要修改这个文件的内容，java代码不需要改动，不需要重新编译，服务器也不需要重新启动，就可以拿到动态的信息

    类似以上机制的这种文件被称为配置文件
    并且当配置文件中的内容格式是：
        key1=value
        key2=value
    的时候，我们把这种配置文件叫做属性配置文件

    java中规范要求：属性配置文件建议以.properties结尾，但不是必须的
    其中properties这个对象是专门存放属性配置文件内容的一个类（属性配置文件中#是注释，名字重复的话会报错，最好不要有空格，不建议用：号）
 */
public class IOPropertiesTest01 {
    public static void main(String[] args) throws Exception{
        //Properties：一个Map集合，key和value都是String类型
        //想将userinfo文件中的数据加载到Properties中
        //首先新建一个输入流对象
        FileReader reader = new FileReader("chapter23/userinfo");

        //新建一个Map集合
        Properties pro = new Properties();

        //调用Properties对象中的方法将文件中的数据加载到Map集合中
        pro.load(reader);  //文件中的数据顺着管道加载到集合当中，其中等号左边做key，右边做value

        //通过key来获取value
        String username = pro.getProperty("username");
        System.out.println(username);  //admin
        //以后需要经常变化的信息不要写到程序里边，写到某种文件当中，通过程序读文件然后动态获取信息

        String password = pro.getProperty("password");
        System.out.println(password);//123
    }
}
