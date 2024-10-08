package com.softnahu.loginobjectstreamvargas.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.softnahu.loginobjectstreamvargas.modelo.Usuario;
import com.softnahu.loginobjectstreamvargas.registro.RegistroActivity;
import com.softnahu.loginobjectstreamvargas.request.ApiClient;

public class LoginActivityViewModel extends AndroidViewModel {
    private Context context;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login (String mail, String pass){
        Usuario usuario2 = ApiClient.login(context,mail,pass);
        if(usuario2!=null){
            if(usuario2.getEmail().equals(mail)&&usuario2.getPassword().equals(pass)){
                Intent intent= new Intent(context, RegistroActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("login",true);
                context.startActivity(intent);
                Toast.makeText(context, "Inicio Sesion", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(context, "Clave Incorrecta", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(context, "Cree un Usuario", Toast.LENGTH_SHORT).show();
        }

    }
    public void registrar (){
            Intent intent = new Intent(context, RegistroActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            Toast.makeText(context, "Registrar usuario", Toast.LENGTH_SHORT).show();
    }

}