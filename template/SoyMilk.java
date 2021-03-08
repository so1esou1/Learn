package com.csu.template;
/*
    抽象类，表示豆浆
 */
public abstract class SoyMilk {
    //一般来说，模板方法可以做成final，表示不允许子类去覆盖
    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }
    void select(){
        System.out.println("第一步:选择新鲜的黄豆");
    }
    //添加不同的配料
    abstract void addCondiments();     //做出抽象方法，因为不知道具体豆浆的配料

    //浸泡
    void soak(){
        System.out.println("第三步:黄豆和配料开始浸泡,需要3小时");
    }

    void beat(){
        System.out.println("第四步:黄豆和配料放到豆浆机去打碎");
    }

}
