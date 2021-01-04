package com.bjpowernode.javase.Collection;

import java.util.Hashtable;
import java.util.Map;

/*了解
Hashtable的key可以为null吗？
    Hashtable的key和value都是不能为null的
Hashtable 方法都带有synchronized:线程安全的，使用较少
底层也是哈希表数据结构
初始化容量是11，默认加载因子是0.75f
Hashtable的扩容：原容量 * 2 + 1
 */
public class HashtableTest01 {
    public static void main(String[] args) {
        Map map = new Hashtable();
        //map.put(null,"123");  出现空指针异常
        //map.put(100,null);   同样出现空指针异常
    }
}
