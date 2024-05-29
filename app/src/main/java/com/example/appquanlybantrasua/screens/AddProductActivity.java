package com.example.appquanlybantrasua.screens;

import static com.example.appquanlybantrasua.App.mCategoriesList;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appquanlybantrasua.R;
import com.example.appquanlybantrasua.databinding.ActivityAddProductBinding;
import com.example.appquanlybantrasua.model.Product;

import java.util.ArrayList;
import java.util.List;

public class AddProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ActivityAddProductBinding binding;
    private String category;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.spinnerCategory.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        for (int i = 0; i < mCategoriesList.size(); i++) {
            categories.add(mCategoriesList.get(i).getName());
        }


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCategory.setAdapter(dataAdapter);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.etName.getText().toString().trim();
                String priceStr= binding.etPrice.getText().toString().trim();

                String des = binding.etDescription.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(priceStr) || TextUtils.isEmpty(des)){
                    Toast.makeText(AddProductActivity.this, "error!", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Tạo và hiển thị AlertDialog
                new AlertDialog.Builder(AddProductActivity.this)
                        .setTitle("Bạn có muốn thêm sản pẩm ko")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int price=Integer.valueOf(priceStr);
                                Product product=new Product(name,price,des,R.drawable.peachmilktea1);
                                for (int i = 0; i < mCategoriesList.size(); i++) {
                                    if (mCategoriesList.get(i).getName().equals(category)){
                                        mCategoriesList.get(i).getProductList().add(product);
                                    }
                                }
                                finish();
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
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        category =adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
