package com.example.exchange.ui.fragment.fav;

import com.example.exchange.data.db.model.Currency;

import java.util.List;

public interface IFavContractor {

    interface View{
        void setFavCurrency(List<Currency> currency);
    }

    interface Presenter{
        void getCurrency();
    }
}
