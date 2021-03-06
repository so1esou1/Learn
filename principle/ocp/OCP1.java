package com.csu.principle.ocp;
/*
    开闭原则:
    分析以下代码:
    1、优点是比较好理解，简单易操作。
    2、缺点是违反了设计模式的ocp原则，即对扩展开放(提供方)，对修改关闭(使用方)
 */
public class OCP1 {
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
    }
}


//这是一个用于绘图的类[使用方]
class GraphicEditor {
    //接收Shape对象，然后根据type来绘制不同的图形
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
        else if (s.m_type == 3)
            drawRectangle(s);
    }
    public void drawRectangle(Shape r) {
        System.out.println("绘制矩形");
    }
    public void drawCircle(Shape r) {
        System.out.println("绘制圆形");
    }

    //需要新增绘制三角形的方法
    public void Triangle(Shape t) {
        System.out.println("绘制三角形");
    }
}
//Shape类，是一个基类
class Shape {
    int m_type;
}
//矩形类
class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}
//圆形类
class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

//新增三角形类
class Triangle extends Shape{
    Triangle(){
        super.m_type = 3;
    }
}