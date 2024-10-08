package com.softnahu.loginobjectstreamvargas.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.softnahu.loginobjectstreamvargas.databinding.ActivityMainBinding;
import com.softnahu.loginobjectstreamvargas.registro.RegistroActivity;

public class LoginActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private LoginActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.login(binding.etUser.getText().toString(),binding.etPass.getText().toString());
            }
        });
        binding.btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.registrar();
            }
        });
    }


}
