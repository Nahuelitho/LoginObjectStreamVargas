package com.softnahu.loginobjectstreamvargas.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softnahu.loginobjectstreamvargas.modelo.Usuario;
import com.softnahu.loginobjectstreamvargas.request.ApiClient;

public class RegistroActivityViewModel extends AndroidViewModel {
    private Context context;

    private MutableLiveData<Usuario> mUser;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getMUser(){
        if (mUser==null){
            mUser=new MutableLiveData<>();
        }
        return mUser;
    }

    public void guardar(Usuario usuario){
        ApiClient.guardar(context,usuario);
        Toast.makeText(context, "Usuario Guardado", Toast.LENGTH_SHORT).show();
    }
    public void leer(Intent intent){
        boolean result = intent.getBooleanExtra("login",false);
        Usuario usuario=ApiClient.leer(context);
        if(usuario==null||!result) {
            mUser.setValue(new Usuario());
        }
        else {
            mUser.setValue(usuario);
        }
    }

}