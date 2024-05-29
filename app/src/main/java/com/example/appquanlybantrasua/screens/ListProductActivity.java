package com.example.appquanlybantrasua.screens;

import static com.example.appquanlybantrasua.App.mCategoriesList;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.appquanlybantrasua.App;
import com.example.appquanlybantrasua.R;
import com.example.appquanlybantrasua.adapter.ProductAdapter;
import com.example.appquanlybantrasua.databinding.ActivityListProductBinding;
import com.example.appquanlybantrasua.model.Categories;
import com.example.appquanlybantrasua.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends AppCompatActivity {
    private ActivityListProductBinding binding;
    List<Product> productList=new ArrayList<>();
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent i=getIntent();
        if (i != null){
            Categories categories=(Categories) i.getSerializableExtra("categories");
            binding.tvTittle.setText(categories.getName());

            productAdapter=new ProductAdapter(new ProductAdapter.OnProductClick() {
                @Override
                public void clickProduct(Product product) {
                    Toast.makeText(ListProductActivity.this, "Click ", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void deleteProduct(Product product) {
                    delete(product);
                }

                @Override
                public void editProduct(Product product) {
                    Toast.makeText(ListProductActivity.this, "edit", Toast.LENGTH_SHORT).show();
                }
            });
            productList=categories.getProductList();
            productAdapter.setmProductList(productList);
            binding.rvProduct.setLayoutManager(new GridLayoutManager(ListProductActivity.this,2));
            binding.rvProduct.setAdapter(productAdapter);
        }
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void delete(Product product) {
        new AlertDialog.Builder(ListProductActivity.this)
                .setTitle("Bạn có muốn xoa sản pẩm ko")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        productList.remove(product);
                        productAdapter.setmProductList(productList);
                        for (int i = 0; i < mCategoriesList.size(); i++) {
                            if (mCategoriesList.get(i).getName().equals(binding.tvTittle.getText().toString().trim())){
                                mCategoriesList.get(i).setProductList(productList);
                            }
                        }
                        // Hành động khi nhấn nút Yes
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Hành động khi nhấn nút No
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
