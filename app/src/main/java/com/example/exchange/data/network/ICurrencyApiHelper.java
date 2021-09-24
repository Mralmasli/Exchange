package com.example.exchange.data.network;

import com.example.exchange.data.db.model.Currency;
import com.example.exchange.data.network.model.GenericModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ICurrencyApiHelper {

    @GET("v1/45cb8eb0-3b54-407c-96ac-eb6b3699ee05")
    Single<Response<GenericModel<List<Currency>>>> getAllCurrencies();
}
