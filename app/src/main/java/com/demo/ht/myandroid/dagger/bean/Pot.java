package com.demo.ht.myandroid.dagger.bean;


/**
 * Created by huangtuo on 2018/6/6.
 */

public class Pot {
    private Flower flower;

//    @Inject
//    public Pot(@Named("Rose") Flower flower) {
//        this.flower = flower;
//    }

//    @Inject
//    public Pot(@LilyFlower Flower flower) {
//        this.flower = flower;
//    }

    public Pot(Flower flower) {
        this.flower = flower;
    }

    public String show(){
        return flower.whisper();
    }
}
