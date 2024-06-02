package com.example.appquanlybantrasua.screens;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appquanlybantrasua.App;
import com.example.appquanlybantrasua.model.Categories;
import com.example.appquanlybantrasua.model.Product;

import java.util.List;
import java.util.Properties;

public class HomeViewModel extends ViewModel {
    public MutableLiveData<List<Categories>> listLiveData;
    public MutableLiveData<List<Product>> listLiveData1;

    public HomeViewModel() {
        this.listLiveData = new MutableLiveData<>();
        Log.d("1H", "HomeViewModel: " + App.mCategoriesList.size());
        listLiveData.setValue(App.mCategoriesList);
        this.listLiveData1 = new MutableLiveData<>();
        listLiveData1.setValue(App.mPopularList);
    }

    public MutableLiveData<List<Categories>> getListLiveData() {
        return listLiveData;
    }

    public MutableLiveData<List<Product>> getListLiveData1() {return listLiveData1;}
}
