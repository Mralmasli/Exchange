package com.example.exchange.di.module;

import com.example.exchange.data.DataManager;
import com.example.exchange.data.IDataManager;
import com.example.exchange.data.db.IDBHelper;
import com.example.exchange.data.network.ICurrencyApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataManagerModule {

    @Provides
    IDataManager provideDataManager(IDBHelper idbHelper, ICurrencyApiHelper iCurrencyApiHelper){
        return new DataManager(iCurrencyApiHelper, idbHelper);
    }
}
