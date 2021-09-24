package com.example.exchange.di.module.presenter;

import com.example.exchange.data.IDataManager;
import com.example.exchange.ui.fragment.fav.FavFragment;
import com.example.exchange.ui.fragment.fav.FavPresenter;
import com.example.exchange.ui.fragment.fav.IFavContractor;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class FavPresenterModule {

    @Binds
    abstract IFavContractor.View provideFavView(FavFragment fragment);

    @Provides
    static FavPresenter providePresenter(IDataManager iDataManager,IFavContractor.View view){
        return new FavPresenter(iDataManager,view);
    }
}
