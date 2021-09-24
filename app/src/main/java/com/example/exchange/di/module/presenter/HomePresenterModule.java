package com.example.exchange.di.module.presenter;


import com.example.exchange.data.IDataManager;
import com.example.exchange.ui.fragment.home.HomeFragment;
import com.example.exchange.ui.fragment.home.HomePresenter;
import com.example.exchange.ui.fragment.home.IHomeContractor;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class HomePresenterModule {

    @Binds
    abstract IHomeContractor.View provideHomeView(HomeFragment homeFragment);

    @Provides
    @Named("homePresenter")
    static HomePresenter provideHomePresenter(IHomeContractor.View view, IDataManager iDataManager){
        return new HomePresenter(iDataManager, view);
    }
}
