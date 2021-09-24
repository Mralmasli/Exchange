package com.example.exchange.ui.fragment.home;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.exchange.data.IDataManager;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.data.network.model.GenericModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class HomePresenter implements IHomeContractor.Presenter{

    private final IDataManager iDataManager;
    private final IHomeContractor.View view;
    private CompositeDisposable disposable;


    @Inject
    public HomePresenter(IDataManager iDataManager, IHomeContractor.View view){
        this.iDataManager = iDataManager;
        this.view = view;
    }

    @Override
    public void getCurrency() {
        if(view == null) return;
        iDataManager.getCurrency().getAllCurrencies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<Response<GenericModel<List<Currency>>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onSuccess(@NonNull Response<GenericModel<List<Currency>>> response) {
                        if (response.body() != null && response.body().getData() != null) {
                            view.setCurrency(response.body().getData());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("TAG", "onError: " + e.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void addToFavourite(Currency currency) {
        iDataManager.getFavCurrencyFromDb().insertFavourite(currency)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();
    }
}
