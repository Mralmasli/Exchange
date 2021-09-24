package com.example.exchange.ui.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.exchange.R;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.databinding.FragmentHomeBinding;
import com.example.exchange.ui.fragment.home.model.OnClickListener;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class HomeFragment extends DaggerFragment implements IHomeContractor.View {

    private static final String TAG = "HomeFragment";

    @Inject
    HomePresenter presenter;

    private FragmentHomeBinding binding;
    private HomeController homeController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeController = new HomeController();
        binding.recyclerView.setController(homeController);
        presenter.getCurrency();
        homeController.clickListener(currency -> {
            presenter.addToFavourite(currency);
            Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void setCurrency(List<Currency> currency) {
        Log.i(TAG, "setCurrency: " + currency);
        homeController.setData(currency);
    }

}