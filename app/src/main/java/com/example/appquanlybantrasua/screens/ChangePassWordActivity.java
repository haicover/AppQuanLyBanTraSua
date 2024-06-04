package com.example.appquanlybantrasua.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appquanlybantrasua.R;
import com.example.appquanlybantrasua.databinding.ActivityChangePassWordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ChangePassWordActivity extends BaseActivity {
    private ActivityChangePassWordBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityChangePassWordBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        binding.btnUpdateChange.setOnClickListener(v -> changePassWord());
    }

    private void changePassWord() {
        String currentPassword = binding.edCurrent.getText().toString().trim();
        String newPassword = binding.edNew.getText().toString().trim();
        String confirmPassword = binding.edConfirm.getText().toString().trim();

        if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(this, "Mật khẩu mới và mật khẩu xác nhận phải trùng khớp", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.getCurrentUser().updatePassword(newPassword)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(ChangePassWordActivity.this, "Cập nhật mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ChangePassWordActivity.this, "Cập nhật mật khẩu thất bại. Vui lòng thử lại.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}