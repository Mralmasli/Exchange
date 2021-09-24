package com.example.exchange.di.module;

import com.example.exchange.di.module.scope.ActivityScope;
import com.example.exchange.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = {
                    NetworkModule.class,
                    DataManagerModule.class,
                    FragmentBuilderModule.class
            }
    )
    abstract MainActivity contributeMainActivity();
 }
