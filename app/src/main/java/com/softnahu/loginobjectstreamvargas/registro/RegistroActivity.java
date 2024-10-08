package com.softnahu.loginobjectstreamvargas.registro;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softnahu.loginobjectstreamvargas.R;
import com.softnahu.loginobjectstreamvargas.databinding.ActivityRegistroBinding;
import com.softnahu.loginobjectstreamvargas.modelo.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);

        binding.btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long dni = Long.parseLong(binding.etDni.getText().toString());
                String apellido = binding.etApellido.getText().toString();
                String nombre = binding.etNombre.getText().toString();
                String mail = binding.etCorreo.getText().toString();
                String pass = binding.etPass.getText().toString();
                Usuario user = new Usuario(dni,apellido,nombre,mail,pass);
                vm.guardar(user);
                binding.etDni.setText("");
                binding.etApellido.setText("");
                binding.etNombre.setText("");
                binding.etCorreo.setText("");
                binding.etPass.setText("");
            }
        });
        vm.getMUser().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etDni.setText(usuario.getDni()+"");
                binding.etApellido.setText(usuario.getApellido());
                binding.etNombre.setText(usuario.getNombre());
                binding.etCorreo.setText(usuario.getEmail());
                binding.etPass.setText(usuario.getPassword());
            }
        });
        vm.leer(getIntent());

    }
}