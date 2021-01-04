package com.bjpowernode.javase.string;

public class StringTest05 {
    public static void main(String[] args) {
        //String类当中的常用方法
        //1、（掌握）char charAt(int index)
        char c = "中国人".charAt(1);//"中国人"是一个字符串对象，只要是对象就能"."
        System.out.println(c);//国

        //2、（了解）int compareTo(String anotherString)
        //字符串间比较大小不能直接使用<>号，需要使用compareTo方法
        int result = "abc".compareTo("abc");
        System.out.println(result);  //0(等于0)前后一致  “10 - 10 = 0”

        int result2 = "abcd".compareTo("abce");
        System.out.println(result2);  //-1（小于0）前小后大  “8 - 9 = -1”

        int result3 = "abce".compareTo("abcd");
        System.out.println(result3);  //1（大于0）前大后小   “9 - 8 = 1”

        //拿着字符串第一个字母和后面字符串的第一个字母比较。能分胜负就不再比较
        System.out.println("xyz".compareTo("yxz")); //-1

        //3、(掌握)boolean contains(CharSequence s)
        //判断前面的字符串是否包含后面的子字符串
        System.out.println("HelloWorld.java".contains(".java"));  //true
        System.out.println("http://www.baidu.com".contains("https://")); //false

        //4、（掌握）boolean endWith(String suffix)
        //判断当前字符串是否以某个字符串结尾。
        System.out.println("test.txt".endsWith(".java")); //false
        System.out.println("test.txt".endsWith(".txt")); //true

        //5、（掌握）boolean equals(Object anObject)
        //比较两个字符串是否相等必须使用equals方法，不能使用字符串
        //equals方法有没有调compareTo方法？老版本调用，JDK13后就不调了
        System.out.println("abc".equals("abc"));//true

        //6、（掌握）boolean equalsIgnoreCase(String anotherString)
        //判断两个字符串是否相等并忽略大小写
        System.out.println("ABC".equalsIgnoreCase("abc"));  //true

        //7、（掌握）byte[] getBytes()
        //将字符串对象转换成字节数组
        byte[] bytes = "abcdef".getBytes();
        for (int i = 0;i < bytes.length;i ++){
            System.out.println(bytes[i]);
        }

        //8、（掌握重点） int indexOf(String str)
        //判断某个字符串在当前字符串中第一次出现处的索引(下标)
        System.out.println("oraclejavac++.netc#phppythonjavaoraclec++".indexOf("java"));

        //9、（掌握）boolean isEmpty()
        //判断某个字符串是否为空。
        String s = "";
        System.out.println(s.isEmpty());  //true

        //10、（掌握）int length()
        //判断字符串的长度
        System.out.println("abc".length());  //3
        //面试题：判断数组长度和判断字符串长度不一样，判断数组长度是Length属性，判断字符串长度是Length()方法

        //11、int LastIndexOf(String str)
        //判断某个字符串在当前字符串中最后一次出现的索引（下标）
        System.out.println("oraclejavaisdxzididosjavaasdsjava".lastIndexOf("java"));

        //12、（掌握） String replace(CharSequence target,CharSequence replacement)
        //替换
        //String的父接口就是CharSequence
        String newString = "http://www.baidu.com".replace("http://","https://");
        System.out.println(newString);

        //13、（掌握）String[] split(String regex)
        //拆分字符串
        String[] ymd = "1980-10-11".split("-");  //将这个字符串以"-"作为拆分
        for (int i = 0;i < ymd.length;i ++){
            System.out.println(ymd[i]);
        }

        //14、（掌握） boolean startsWith(String prefix) 与4类似
        //判断某个字符串是否以某个子字符串开始
        System.out.println("http://www.baidu.com".startsWith("http"));//true

        //15、（掌握） String substring(int beginIndex)
        //截取字符串
        System.out.println("http://www.baidu.com".substring(7));//www.baidu.com从下标为7的开始截取

        //16（掌握）String substring(int beginIndex,int endIndex)
        //int beginIndex是起始位置，包括；int endIndex是结束位置，不包括
        System.out.println("http://www.baidu.com".substring(7,10));//www左闭右开，7包含，10不包含

        //17、（掌握）char[] toCharArray()
        //将字符串转换为char数组
        char[] chars = "我是中国人".toCharArray();
        for (int i = 0;i < chars.length;i++){
            System.out.println(chars[i]);//我  是   中    国    人
        }

        //18、(掌握)String toLowerCase()
        //转换为小写
        System.out.println("ABCDefkXyz".toLowerCase());  //abcdefkxyz

        //19、（掌握）String toUpperCase()
        //转换为大写
        System.out.println("ABCDefkXyz".toUpperCase());//ABCDEFKXYZ

        //20、（掌握）String trim()
        //去除字符串前后空白
        System.out.println("       hello   world     ".trim());//hello   world

        //21、(掌握)String中只有一个方法是静态的，不需要new对象
        //这个方法叫做valueOf
        //可以将非字符串转换成字符串
        /*String s1 = String.valueOf(true);
        System.out.println(s1);//true*/

        //这个静态的valueOf()方法，参数是一个对象的时候，会自动调用该对象的toString()方法吗？
        String s1 = String.valueOf(new Customer());
        //System.out.println(s1);//com.bjpowernode.javase.string.Customer@7ef20235   没有重写toString()方法前是对象的内存地址
        System.out.println(s1);//我是一个VIP客户！！！


        //我们可以研究下println()方法的源代码了？
        System.out.println(100);//按ctrl去找源代码
        System.out.println(3.14);
        System.out.println(true);
        System.out.println(new Object());
        //能够打印出来控制台的其实都是字符串ValueOf转成字符串了
        //本质上System.out.println()这个方法在输出任何数据的时候都是先转换成字符串再输出
    }
}
class Customer{
  //重写toString()方法
    public String toString(){
        return "我是一个VIP客户！！！";
    }
}
