package com.example.exchange.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.exchange.R;
import com.example.exchange.data.db.model.Currency;
import com.example.exchange.data.network.ICurrencyApiHelper;
import com.example.exchange.data.network.model.GenericModel;
import com.example.exchange.databinding.ActivityMainBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivity extends DaggerAppCompatActivity {

    private NavController navController;
    private NavHostFragment navHostFragment;
    private ActivityMainBinding binding;

    @Inject
    ICurrencyApiHelper iCurrencyApiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupNavigation();
    }

    private void setupNavigation(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        navController = navHostFragment.getNavController();//Navigation.findNavController(this,R.id.fragmentContainerView2);
        NavigationUI.setupWithNavController(binding.bottomNav,navController);
        binding.bottomNav.setOnNavigationItemSelectedListener(item -> {
            NavigationUI.onNavDestinationSelected(item, navController);
            return true;
        });
    }
}