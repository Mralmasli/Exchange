package com.example.exchange.data;

import com.example.exchange.data.db.IDBHelper;
import com.example.exchange.data.network.ICurrencyApiHelper;

public interface IDataManager {

    IDBHelper getFavCurrencyFromDb();

    ICurrencyApiHelper getCurrency();
}
