package com.example.exchange.data;

import com.example.exchange.data.db.IDBHelper;
import com.example.exchange.data.network.ICurrencyApiHelper;

import javax.inject.Inject;

public class DataManager implements IDataManager{

    ICurrencyApiHelper iCurrencyApiHelper;
    IDBHelper idbHelper;

    @Inject
    public DataManager(ICurrencyApiHelper iCurrencyApiHelper, IDBHelper idbHelper){
        this.iCurrencyApiHelper = iCurrencyApiHelper;
        this.idbHelper = idbHelper;
    }

    @Override
    public IDBHelper getFavCurrencyFromDb() {
        return idbHelper;
    }

    @Override
    public ICurrencyApiHelper getCurrency() {
        return iCurrencyApiHelper;
    }
}
