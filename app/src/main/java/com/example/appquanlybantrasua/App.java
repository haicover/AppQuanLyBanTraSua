package com.example.appquanlybantrasua;

import android.app.Application;

import com.example.appquanlybantrasua.model.Categories;
import com.example.appquanlybantrasua.model.Product;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public static List<Categories> mCategoriesList=new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mCategoriesList = getListCategory();

    }

    private List<Categories> getListCategory() {
        List<Categories> list =new ArrayList<>();
        list.add(new Categories("Red", getListProduct()));
        list.add(new Categories("Yellow", getListProduct()));
        list.add(new Categories("Black", getListProduct()));
        list.add(new Categories("White", getListProduct()));
        return list;
    }

    private List<Product> getListProduct() {
        List<Product> productList=new ArrayList<>();
        productList.add(new Product("apple",120,"ngon cacacca cascac ccascascascac", R.drawable.peachmilktea1));
        productList.add(new Product("banana",500,"do xxxxxxxxxxxxxx yyyyyyyyyy ttttttttttttt",R.drawable.peachmilktea1));
        productList.add(new Product("candy",1000,"zzzzzzzzzzz cascsacsac eeeeeeeeeeeeee ccascascascacaeeeeeeeeeeeeeeeeeecac",R.drawable.peachmilktea1));
        return productList;
    }
}
