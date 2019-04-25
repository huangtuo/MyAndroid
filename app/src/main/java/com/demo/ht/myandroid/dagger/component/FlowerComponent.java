package com.demo.ht.myandroid.dagger.component;


import com.demo.ht.myandroid.dagger.bean.Flower;
import com.demo.ht.myandroid.dagger.flower.LilyFlower;
import com.demo.ht.myandroid.dagger.flower.RoseFlower;
import com.demo.ht.myandroid.dagger.module.FlowerModule;

import dagger.Component;

/**
 * Created by huangtuo on 2018/6/7.
 */
@Component(modules = FlowerModule.class)
public interface FlowerComponent {
    @RoseFlower
    Flower getRoseFlower();

    @LilyFlower
    Flower getLilyFlower();

}
