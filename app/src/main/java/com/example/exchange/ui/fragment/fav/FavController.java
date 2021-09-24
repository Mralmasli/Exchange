package com.example.exchange.ui.fragment.fav;

import com.airbnb.epoxy.TypedEpoxyController;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.ui.fragment.fav.model.FavEpoxyModel_;

import java.util.List;
import java.util.Random;

public class FavController extends TypedEpoxyController<List<Currency>> {
    @Override
    protected void buildModels(List<Currency> data) {
        for (Currency currency : data) {
            new FavEpoxyModel_()
                    .id(new Random().nextLong())
                    .currency(currency)
                    .addTo(this);
        }
    }
}
