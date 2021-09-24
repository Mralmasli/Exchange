package com.example.exchange.di;

import android.app.Application;

import com.example.exchange.ExchangeApplication;
import com.example.exchange.di.module.ActivityBuilderModule;
import com.example.exchange.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilderModule.class,
})
public interface AppComponent extends AndroidInjector<ExchangeApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }
}
