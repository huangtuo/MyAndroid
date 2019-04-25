package com.demo.ht.myandroid.dagger.component;


import com.demo.ht.myandroid.activity.MainActivity;

import dagger.Component;

/**
 * Created by huangtuo on 2018/6/6.
 */
//@Component(modules = {FlowerModule.class, PotModule.class})
@Component(dependencies = PotComponent.class)
public interface DaggerTestComponent {
    void inject(MainActivity activity);
}
