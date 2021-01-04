package bjpowernode.java.io;



import bjpowernode.java.bean.Student;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
序列化：
    1、参与序列化和反序列化的对象必须实现接口Serializable
    2、通过源代码发现，Serializable接口只是一个标志接口，里面什么也没有：
        public interface Serializable {
        }
        起到标志的作用，java虚拟机看到这个类实现这个接口，可能会对这个类进行特殊待遇
 */
//出现异常：NotSerializableException
    //Student不支持序列化！！！需要实现接口：Serializable（标识性接口，里面没有任何方法）
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) throws Exception{
        //创建对象
        Student s = new Student(1111,"zhangsan");
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students"));
        //序列化对象
        oos.writeObject(s);
        //刷新
        oos.flush();
        //关闭
        oos.close();
    }
}
