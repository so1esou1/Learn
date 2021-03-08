package com.csu.template.improve;
/*
    抽象类，表示豆浆
 */
public abstract class SoyMilk {
    final void make(){
        select();
        //如果customerWantCondiments为真，就添加配料
        if (customerWantCondiments()){
            addCondiments();
        }

        soak();
        beat();
    }

    //添加一个钩子方法，决定是否需要添加配料:
    boolean customerWantCondiments(){
        return true;
    }


    void select(){
        System.out.println("第一步:选择新鲜的黄豆");
    }
    abstract void addCondiments();     //做出抽象方法，因为不知道具体豆浆的配料
    void soak(){
        System.out.println("第三步:黄豆和配料开始浸泡,需要3小时");
    }
    void beat(){
        System.out.println("第四步:黄豆和配料放到豆浆机去打碎");
    }

}
