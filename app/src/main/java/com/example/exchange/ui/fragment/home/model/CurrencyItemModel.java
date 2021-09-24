package com.example.exchange.ui.fragment.home.model;

import static com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash;

import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;
import com.example.exchange.R;
import com.example.exchange.data.db.model.Currency;

@EpoxyModelClass(layout = R.layout.epoxy_model_currency_item)
public abstract class CurrencyItemModel extends EpoxyModelWithHolder<CurrencyItemModel.Holder> {

    @EpoxyAttribute
    Currency currency;
    @EpoxyAttribute
    OnClickListener onClickListener;

    @Override
    public void bind(@NonNull Holder holder) {
        super.bind(holder);
        holder.tvName.setText(currency.getName());
        holder.tvSellRate.setText(currency.getSaleRate().toString());
        holder.tvBuyRate.setText(currency.getBuyRate().toString());
        holder.iv.setOnClickListener(v -> onClickListener.clicked(currency));
    }

    class Holder extends EpoxyHolder{

        TextView tvName;
        TextView tvBuyRate;
        TextView tvSellRate;
        ImageView iv;

        @Override
        protected void bindView(@NonNull View itemView) {
            tvName = itemView.findViewById(R.id.tv_name);
            tvBuyRate= itemView.findViewById(R.id.tv_buy_rate);
            tvSellRate = itemView.findViewById(R.id.tv_sell_rate);
            iv = itemView.findViewById(R.id.iv_add_fav);
        }
    }
}
