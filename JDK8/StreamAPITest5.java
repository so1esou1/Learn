package com.bjpowernode.java2.JDK8;
/*
    Stream 的终止操作:
    终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是 void
    流进行了终止操作后，不能再次使用。

    1-匹配与查找:

    allMatch(Predicate p)   检查是否匹配所有元素
    anyMatch(Predicate p)   检查是否至少匹配一个元素
    noneMatch(Predicate p)  检查是否没有匹配所有元素
    findFirst()             返回第一个元素
    findAny()               返回当前流中的任意元素
    count()                 返回流中元素总数
    max(Comparator c)       返回流中最大值
    min(Comparator c)       返回流中最小值
    forEach(Consumer c)     内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
 */
public class StreamAPITest5 {
    public static void main(String[] args) {

        //1、allMatch(Predicate p)   检查是否匹配所有元素
        //employyes.stream().allMatch(e -> e.getAge() > 19);
        //其他同理
    }
}
