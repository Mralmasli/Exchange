package com.example.exchange.data.db;

import com.example.exchange.data.db.model.Currency;
import com.example.exchange.data.db.model.DaoMaster;
import com.example.exchange.data.db.model.DaoSession;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class DBHelperImpl implements IDBHelper{

    private final DaoSession daoSession;

    @Inject
    public DBHelperImpl(DBOpenHelper dbOpenHelper){
        daoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertFavourite(Currency currency) {
        return Observable.fromCallable(() -> daoSession.getCurrencyDao().insert(currency));
    }

    @Override
    public Observable<List<Currency>> getAllFav() {
        return Observable.fromCallable(() -> daoSession.getCurrencyDao().loadAll());
    }

    @Override
    public Observable<Boolean> deleteFavourite(Currency currency) {
        return Observable.fromCallable(() -> null);
    }
}
