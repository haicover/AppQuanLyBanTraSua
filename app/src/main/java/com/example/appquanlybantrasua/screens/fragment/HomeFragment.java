package com.example.appquanlybantrasua.screens.fragment;

import static com.example.appquanlybantrasua.App.mCategoriesList;
import static com.example.appquanlybantrasua.App.mPopularList;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.appquanlybantrasua.R;
import com.example.appquanlybantrasua.adapter.CategoryAdapter;
import com.example.appquanlybantrasua.adapter.ProductAdapter;
import com.example.appquanlybantrasua.databinding.FragmentHomeBinding;
import com.example.appquanlybantrasua.model.Categories;
import com.example.appquanlybantrasua.model.Product;
import com.example.appquanlybantrasua.screens.AddProductActivity;
import com.example.appquanlybantrasua.screens.HomeActivity;
import com.example.appquanlybantrasua.screens.HomeViewModel;
import com.example.appquanlybantrasua.screens.ListProductActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private static final String TAG = "1HomeFragment";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CategoryAdapter categoryAdapter = new CategoryAdapter(new CategoryAdapter.OnCategoryClick() {
            @Override
            public void clickCategory(Categories categories) {
                startActivity(new Intent(requireContext(), ListProductActivity.class).putExtra("categories", categories));
            }
        });
        ProductAdapter productAdapter = new ProductAdapter(new ProductAdapter.OnProductClick() {
            @Override
            public void clickProduct(Product product) {
                startActivity(new Intent(requireContext(), ListProductActivity.class));
            }

            @Override
            public void deleteProduct(Product product) {
            }

            @Override
            public void editProduct(Product product) {
            }
        });
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> categories) {
                Log.d(TAG, "onChanged: " + categories.size());
                categoryAdapter.setmCategoriesList(categories);
            }
        });
        homeViewModel.listLiveData1.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                Log.d(TAG, "onChanged: " + products.size());
                productAdapter.setmProductList(products);
            }
        });

        binding.rvCategory.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvCategory.setAdapter(categoryAdapter);

        binding.rvPopularProduct.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvPopularProduct.setAdapter(productAdapter);


        binding.editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Product> filteredProducts = new ArrayList<>();
                ArrayList<Categories> filteredCategories = new ArrayList<>();
                for (Product pro : mPopularList) {
                    if (pro.getName().contains(s)) {
                        filteredProducts.add(pro);
                    }
                }
                productAdapter.setmProductList(filteredProducts);

                for (Categories cate : mCategoriesList) {
                    if (cate.getName().contains(s)) {
                        filteredCategories.add(cate);
                    }
                }
                categoryAdapter.setmCategoriesList(filteredCategories);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}