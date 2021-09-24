package com.example.exchange.ui.fragment.home;

import com.example.exchange.data.db.model.Currency;

import java.util.List;

public interface IHomeContractor {

    interface View{
        void setCurrency(List<Currency> currency);
    }

    interface Presenter{
        void getCurrency();
        void addToFavourite(Currency currency);
    }
}
