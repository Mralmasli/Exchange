package com.example.exchange.data.db;

import com.example.exchange.data.db.model.Currency;

import java.util.List;

import io.reactivex.Observable;

public interface IDBHelper {
    Observable<Long> insertFavourite(final Currency currency);

    Observable<List<Currency>> getAllFav();

    Observable<Boolean> deleteFavourite(final Currency currency);
}
