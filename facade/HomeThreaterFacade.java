package com.csu.facade;
/*
    影院的外观类
 */
public class HomeThreaterFacade {
    //先定义各个子系统对象
    private TheaterLight theaterLight;
    private Popcorn popcorn;
    private Stereo stereo;
    private Screen screen;
    private Projector projector;
    private DVDPlayer dvdPlayer;
    //在构造器中初始化:
    public HomeThreaterFacade() {
        //使用单例模式获取
        this.theaterLight = TheaterLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.screen = Screen.getInstance();
        this.projector = Projector.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    //把操作分成四步:

    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }
    public void play(){
        dvdPlayer.play();
    }
    public void pause(){
        dvdPlayer.pause();
    }
    public void end(){
        popcorn.off();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();
        theaterLight.bright();
    }

}
