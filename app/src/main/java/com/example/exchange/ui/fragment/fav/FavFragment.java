package com.example.exchange.ui.fragment.fav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exchange.R;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.databinding.FragmentFavBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class FavFragment extends DaggerFragment implements IFavContractor.View{

    @Inject
    FavPresenter favPresenter;

    private FavController favController;

    private FragmentFavBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favController = new FavController();
        binding.recyclerView.setController(favController);
        favPresenter.getCurrency();
    }

    @Override
    public void setFavCurrency(List<Currency> currency) {
        Log.i("TAG", "setFavCurrency: " + currency);
        favController.setData(currency);
    }

}