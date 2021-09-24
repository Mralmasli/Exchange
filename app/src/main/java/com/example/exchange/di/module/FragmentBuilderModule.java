package com.example.exchange.di.module;

import com.example.exchange.di.module.presenter.FavPresenterModule;
import com.example.exchange.di.module.presenter.HomePresenterModule;
import com.example.exchange.di.module.scope.FragmentScope;
import com.example.exchange.ui.fragment.fav.FavFragment;
import com.example.exchange.ui.fragment.home.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(
            modules = {
                    HomePresenterModule.class
            }
    )
    abstract HomeFragment provideHomeFragment();

    @FragmentScope
    @ContributesAndroidInjector(
            modules = {
                    FavPresenterModule.class
            }
    )
    abstract FavFragment provideFavFragment();
}
