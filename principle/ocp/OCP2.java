package com.csu.principle.ocp;
/*
    使用OCP原则改进1中的代码
    思路：把创建Shape类做成抽象类，并提供一个抽象的draw方法，让子类去实现即可
 */
public class OCP2 {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());

    }
}



class GraphicEditor1 {
    public void drawShape(Shape1 s) {
        //接收Shape对象，调用draw方法即可
        s.draw();

        /*分支判断也不需要了
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
        else if (s.m_type == 3)
            drawRectangle(s);
        */
    }
    /*这三个方法不要了，让子类去实现方法
    public void drawRectangle(Shape1 r) {
        System.out.println("绘制矩形");
    }
    public void drawCircle(Shape1 r) {
        System.out.println("绘制圆形");
    }
    public void drowTriangle(Shape1 t) {
        System.out.println("绘制三角形");
    }
    */

}

//Shape类，是一个基类,做成一个抽象的类
abstract class Shape1 {
    int m_type;
    //抽象方法
    public abstract void draw();        //子类要去实现这个方法
}
class Rectangle1 extends Shape1 {
    Rectangle1() {
        super.m_type = 1;
    }
    public void draw(){
        System.out.println("绘制矩形");
    }
}
class Circle1 extends Shape1 {
    Circle1() {
        super.m_type = 2;
    }
    public void draw(){
        System.out.println("绘制圆形");
    }
}
class Triangle1 extends Shape1{
    Triangle1(){
        super.m_type = 3;
    }
    public void draw(){
        System.out.println("绘制三角形");
    }
}

//新增一个图形,只需要新增这里，只需要使用方修改即可
class Other extends Shape1{
    Other(){
        super.m_type = 4;
    }
    public void draw(){
        System.out.println("绘制其他图形");
    }
}
