package com.example.appquanlybantrasua.screens;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appquanlybantrasua.App;
import com.example.appquanlybantrasua.model.Categories;

import java.util.List;

public class HomeViewModel extends ViewModel {
    public MutableLiveData<List<Categories>> listLiveData;

    public HomeViewModel() {
        this.listLiveData = new MutableLiveData<>();
        Log.d("1H", "HomeViewModel: "+App.mCategoriesList.size());
        listLiveData.setValue(App.mCategoriesList);
    }

    public MutableLiveData<List<Categories>> getListLiveData() {
        return listLiveData;
    }
}
