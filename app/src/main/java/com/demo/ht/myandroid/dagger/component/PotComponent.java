package com.demo.ht.myandroid.dagger.component;

import com.demo.ht.myandroid.dagger.bean.Pot;
import com.demo.ht.myandroid.dagger.module.PotModule;

import dagger.Component;

/**
 * Created by huangtuo on 2018/6/7.
 */
@Component(modules = PotModule.class, dependencies = FlowerComponent.class)
public interface PotComponent {
    Pot getPot();

}
