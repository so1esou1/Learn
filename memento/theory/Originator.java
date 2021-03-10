package com.csu.memento.theory;

public class Originator {
    private String state;       //状态信息
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    //编写一个方法，可以保存一个状态对象Memento
    //因此编写一个对象，返回Memento
    public Memento saveStateMemento(){
        return new Memento(state);
    }
    //通过备忘录对象恢复状态的话只需要恢复这个属性就行
    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
