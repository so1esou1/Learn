package com.csu.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
    贪心算法代码实现
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建电台的集合,放入到hashMap中进行管理
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //将这些电台加入到hashmap
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);


        //建一个allAreas存放所有地区
        HashSet<String> allAreas = new HashSet<>();
        //将所有地区放进去(一般通过代码写进去,不手写)
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建一个ArrayList,存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义一个maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖地区对应的电台的key
        //如果maxKey不为空，则会加入到selects里面(这个maxKey指向的对象中还有未被收录的地区)
        String maxKey = null;
        while (allAreas.size() != 0){       //如果allAreas不为0则表示还没有覆盖到所有地区
            //每进行一次while,就需要把maxkey置空
            maxKey = null;

            //遍历broadcasts,取出对应的key
            for (String key : broadcasts.keySet()){
                //每进行一次for，都需要把temp清空
                tempSet.clear();

                HashSet<String> areas = broadcasts.get(key);        //代表当前key能够覆盖的地区
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);        //tempSet与allAreas取交集，retainAll()是取交集的方法,交集的结果会赋给tempSet，替代其原来的值(不属于交集的那部分被删除)

                //如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合未覆盖的地区还要多
                //就需要重置maxKey
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
                //tempSet.size() > broadcasts.get(maxKey).size()  这句话就体现出贪心算法的贪婪性
            }
            //如果经过这一轮遍历，发现maxkey!=null，就应该将maxkey加入到seelcts集合中
            if (maxKey != null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allAreas中清除掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果:");
        System.out.println(selects);
    }
}
