package com.example.exchange.ui.fragment.fav;

import androidx.annotation.NonNull;

import com.example.exchange.data.IDataManager;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.ui.fragment.home.IHomeContractor;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;

public class FavPresenter implements IFavContractor.Presenter{

    private final IDataManager iDataManager;
    private final IFavContractor.View view;

    public FavPresenter(IDataManager iDataManager, IFavContractor.View view) {
        this.iDataManager = iDataManager;
        this.view = view;
    }

    @Override
    public void getCurrency() {
        iDataManager.getFavCurrencyFromDb().getAllFav()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BlockingBaseObserver<List<Currency>>() {
                    @Override
                    public void onNext(@NonNull List<Currency> currencies) {
                        view.setFavCurrency(currencies);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}
