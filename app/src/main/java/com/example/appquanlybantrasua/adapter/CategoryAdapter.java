package com.example.appquanlybantrasua.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlybantrasua.databinding.ItemCategoryBinding;
import com.example.appquanlybantrasua.model.Categories;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Categories> mCategoriesList;
    private OnCategoryClick onCategoryClick;

    public CategoryAdapter(OnCategoryClick onCategoryClick) {
        this.onCategoryClick = onCategoryClick;
    }

    public interface OnCategoryClick{
        void clickCategory(Categories categories);
    }
    public void setmCategoriesList(List<Categories> mCategoriesList) {
        this.mCategoriesList = mCategoriesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding=ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.binData(mCategoriesList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mCategoriesList!=null){
            return mCategoriesList.size();
        }
        return 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ItemCategoryBinding binding;
        public CategoryViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void binData(Categories categories) {
            binding.tvCategory.setText(categories.getName());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCategoryClick.clickCategory(categories);
                }
            });
        }
    }
}
