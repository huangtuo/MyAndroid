package com.demo.ht.myandroid.dagger.module;


import com.demo.ht.myandroid.dagger.bean.Flower;
import com.demo.ht.myandroid.dagger.bean.Pot;
import com.demo.ht.myandroid.dagger.flower.RoseFlower;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangtuo on 2018/6/7.
 */
@Module
public class PotModule {

    @Provides
    Pot providePot(@RoseFlower Flower flower){
        return new Pot(flower);
    }
}
