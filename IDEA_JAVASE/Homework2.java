import java.sql.SQLOutput;

public class Homework2 {
    public static void main(String[] args) {
        //通过无参数构造方法创建对象
        Vehicle v = new Vehicle();
        v.setSpeed(120);
        v.setSize(5);
        //通过有参数构造方法创建对象
        Vehicle v1 = new Vehicle(120,5);
        System.out.println("speed : " + v.getSpeed());
        System.out.println("size : " + v.getSize());
        //调用加速方法
        v.speedUp(10);
        System.out.println("speed : " + v.getSpeed());
        //调用减速方法
        v.speedDown(10) ;
        System.out.println("speed : " + v.getSpeed());
    }
}
class Vehicle{
    private int speed;
    private int size;

    public Vehicle() {
    }

    public Vehicle(int speed, int size) {
        this.speed = speed;
        this.size = size;
    }
    public int getSpeed() {
        return speed;
    }
//设置速度的方法
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

//交通工具的移动方法
    public void move(){
        System.out.println("交通工具：公共汽车，起步行驶。");

    }
//加速方法
    public void speedUp(int addSpeed){
    int oldSpeed = this.getSpeed();
    this.setSpeed(oldSpeed + addSpeed);
    }
//减速方法
    public void speedDown(int subSpeed){
    int oldSpeed = this.getSpeed();
        //最好有一个判断，防止小于零
    this.setSpeed(oldSpeed - subSpeed);
    }
}
