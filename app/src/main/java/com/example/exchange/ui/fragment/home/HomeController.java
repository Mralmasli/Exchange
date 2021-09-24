package com.example.exchange.ui.fragment.home;

import com.airbnb.epoxy.TypedEpoxyController;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.ui.fragment.home.model.CurrencyItemModel_;
import com.example.exchange.ui.fragment.home.model.OnClickListener;

import java.util.List;

public class HomeController extends TypedEpoxyController<List<Currency>> implements OnClickListener {

    private OnClickListener onClickListener;

    @Override
    protected void buildModels(List<Currency> currencies) {

        for (Currency data: currencies) {
            new CurrencyItemModel_()
                    .id(data.getName())
                    .currency(data)
                    .onClickListener(this)
                    .addTo(this);
        }
    }

    @Override
    public void clicked(Currency currency) {
        System.out.print("" + currency.getName());
        onClickListener.clicked(currency);
    }

    public void clickListener(OnClickListener onClickListener)  {
        this.onClickListener = onClickListener;
    }
}
