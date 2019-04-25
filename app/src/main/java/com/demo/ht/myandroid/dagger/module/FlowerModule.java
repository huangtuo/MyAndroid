package com.demo.ht.myandroid.dagger.module;


import com.demo.ht.myandroid.dagger.bean.Flower;
import com.demo.ht.myandroid.dagger.bean.Lily;
import com.demo.ht.myandroid.dagger.bean.Rose;
import com.demo.ht.myandroid.dagger.flower.LilyFlower;
import com.demo.ht.myandroid.dagger.flower.RoseFlower;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangtuo on 2018/6/7.
 */
@Module
public class FlowerModule {

    //    @Provides
//    @Named("Rose")
//    Flower providerRose(){
//        return new Rose();
//    }
//
//    @Provides
//    @Named("Lily")
//    Flower providerLily(){
//        return new Lily();
//    }
    @Provides
    @RoseFlower
    Flower providerRose() {
        return new Rose();
    }

    @Provides
    @LilyFlower
    Flower providerLily() {
        return new Lily();
    }

}
