package com.example.appquanlybantrasua.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appquanlybantrasua.R;
import com.example.appquanlybantrasua.databinding.ActivityHomeBinding;
import com.example.appquanlybantrasua.model.Categories;
import com.example.appquanlybantrasua.model.Product;
import com.example.appquanlybantrasua.screens.fragment.CartFragment;
import com.example.appquanlybantrasua.screens.fragment.FavouriteFragment;
import com.example.appquanlybantrasua.screens.fragment.HomeFragment;
import com.example.appquanlybantrasua.screens.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showHome();
        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHome();

            }
        });
        binding.btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCart();

            }
        });
        binding.btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFavourite();

            }
        });
        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSetting();

            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AddProductActivity.class));
            }
        });
    }

    private void showSetting() {
        binding.ivHome.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivCart.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivFavorite.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivSetting.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.tvHome.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvCart.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvFavorite.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvSetting.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        loadFragment(SettingFragment.newInstance("",""));
    }

    private void showFavourite() {
        binding.ivHome.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivCart.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivFavorite.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.ivSetting.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvHome.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvCart.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvFavorite.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.tvSetting.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        loadFragment(FavouriteFragment.newInstance("",""));
    }

    private void showCart() {
        binding.ivHome.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivCart.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.ivFavorite.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivSetting.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvHome.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvCart.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.tvFavorite.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvSetting.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        loadFragment(CartFragment.newInstance("",""));
    }

    private void showHome() {
        binding.ivHome.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.ivCart.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivFavorite.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.ivSetting.setColorFilter(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvHome.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.colorYellow));
        binding.tvCart.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvFavorite.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        binding.tvSetting.setTextColor(ContextCompat.getColor(HomeActivity.this,R.color.color4));
        loadFragment(HomeFragment.newInstance("",""));
    }

    private void loadFragment(Fragment fragment) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container_view);

        if (currentFragment == null || !currentFragment.getClass().equals(fragment.getClass())) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_view, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }


}