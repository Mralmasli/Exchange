package com.example.exchange.di.module;

import com.example.exchange.data.network.ICurrencyApiHelper;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    ICurrencyApiHelper provideCurrencyHelper(Retrofit retrofit){
        return retrofit.create(ICurrencyApiHelper.class);
    }
}
