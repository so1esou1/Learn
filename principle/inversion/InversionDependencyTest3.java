package com.csu.principle.inversion;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
    依赖倒置的三种方式:
    1) 接口传递
    2) 构造方法传递
    3) setter方式传递
 */
public class InversionDependencyTest3 {
    public static void main(String[] args) {
        ChangHong changHong = new ChangHong();
//		OpenAndClose openAndClose = new OpenAndClose();
//		openAndClose.open(changHong);

        //通过构造器进行依赖传递
//		OpenAndClose openAndClose = new OpenAndClose(changHong);
//		openAndClose.open();

        //通过setter方法进行依赖传递
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(changHong);      //changhong实现了ITV接口
        openAndClose.open();
    }
}



//方式1：
//开关的接口
/*

interface IOpenAndClose{
    public void open(ITV tv);       //抽象方法接收接口
}
interface ITV{
    public void play();
}
//实现接口
class OpenAndClose implements IOpenAndClose{
    public void open(ITV tv){
        tv.play();
    }
}

class ChangHong implements ITV {
	@Override
	public void play() {
		System.out.println("长虹电视机，打开");
	}
}
 */


//方式2:通过构造方法依赖传递
/*

interface IOpenAndClose{
    public void open();       //抽象方法
}
interface ITV{
    public void play();
}
class OpenAndClose implements IOpenAndClose{
    public ITV tv;      //成员
    public OpenAndClose(ITV tv){        //构造器,传入ITV类型的值，与之关联
        this.tv = tv;
    }
    public void open(){
        this.tv.play();
    }
}

 */




//方式3:通过setter方法传递
interface IOpenAndClose{
    public void open();
    public void setTv(ITV tv);
}
interface ITV{
    public void play();
}

class OpenAndClose implements IOpenAndClose{
    private ITV tv;
    public void setTv(ITV tv){
        this.tv = tv;
    }
    public void open(){
        this.tv.play();
    }
}
class ChangHong implements ITV {

    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }

}