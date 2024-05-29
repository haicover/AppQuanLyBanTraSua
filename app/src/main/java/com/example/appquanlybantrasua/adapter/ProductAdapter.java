package com.example.appquanlybantrasua.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlybantrasua.databinding.ItemProductBinding;
import com.example.appquanlybantrasua.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> mProductList;
    private OnProductClick onProductClick;

    public ProductAdapter(OnProductClick onProductClick) {
        this.onProductClick = onProductClick;
    }

    public interface OnProductClick {
        void clickProduct(Product product);
        void deleteProduct(Product product);
        void editProduct(Product product);
    }
    public void setmProductList(List<Product> mProductList) {
        this.mProductList = mProductList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding binding=ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.binData(mProductList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mProductList!=null){
            return mProductList.size();
        }
        return 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        private ItemProductBinding binding;
        public ProductViewHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void binData(Product product) {
            binding.tvName.setText(product.getName());
            binding.tvPrice.setText(product.getPrice()+"");
            binding.ivIcon.setImageResource(product.getIcon());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onProductClick.clickProduct(product);
                }
            });

            binding.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onProductClick.deleteProduct(product);
                }
            });

            binding.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onProductClick.editProduct(product);
                }
            });
        }
    }
}
