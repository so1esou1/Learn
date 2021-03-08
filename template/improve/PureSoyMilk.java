package com.csu.template.improve;
//纯豆浆，不添加任何配料
public class PureSoyMilk extends SoyMilk{
    @Override
    void addCondiments() {
        //空实现就行
    }

    @Override
    boolean customerWantCondiments() {
        return false;       //将customerWantCondiments改成false
    }
}
