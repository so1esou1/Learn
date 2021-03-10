package com.csu.memento.theory;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("状态1");

        //保存当前的状态
        careTaker.add(originator.saveStateMemento());

        originator.setState("状态2");
        careTaker.add(originator.saveStateMemento());

        originator.setState("状态3");
        careTaker.add(originator.saveStateMemento());


        System.out.println("当前的状态是:" + originator.getState());
        //希望恢复到状态1
        originator.getStateFromMemento(careTaker.get(0));//先获得第一个状态的对象
        System.out.println("恢复到状态1后:" + originator.getState());
    }
}
