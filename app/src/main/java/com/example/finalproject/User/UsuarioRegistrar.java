package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.clase.User;

public class UsuarioRegistrar extends AppCompatActivity {

    private String userName;
    private String password;

    private String name;
    private String surname;
    private String phone;
    private Integer age;
    private String poblation;
    private String email;
    private boolean inmune;

    private EditText Rname;
    private EditText Rsurname;
    private EditText Rphone;
    private EditText Rage;
    private EditText Rpoblation;
    private EditText Remail;
    private EditText Rinmune;

    private EditText RuserName;
    private EditText Rpassword;

    Button confirm;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_registrar);

        Rname=findViewById(R.id.Rname);
        Rsurname=findViewById(R.id.Rsurname);
        RuserName=findViewById(R.id.Rusername);
        Rpassword=findViewById(R.id.Rpassword);
        Rphone=findViewById(R.id.RphoneNumber);
        Rage=findViewById(R.id.Rage);
        Rpoblation=findViewById(R.id.Rpoblation);
        Remail=findViewById(R.id.Remail);
        //Immune chebox falta

        cancel=findViewById(R.id.Rcancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioRegistrar.this, MainActivity.class);
                startActivity(intent);
            }
        });

        confirm=findViewById(R.id.Rconfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName=RuserName.getText().toString();
                password=Rpassword.getText().toString();
                name=Rname.getText().toString();
                surname=Rsurname.getText().toString();
                phone=Rphone.getText().toString();
                String agee = Rage.getText().toString();
                age=Integer.parseInt(agee);
                poblation=Rpoblation.getText().toString();
                email=Remail.getText().toString();

                if (name.isEmpty()){
                    error(getString(R.string.name));
                }else if (surname.isEmpty()){
                    error(getString(R.string.surname));
                }else if (userName.isEmpty()){
                    error(getString(R.string.username));
                }else if (password.isEmpty()){
                    error(getString(R.string.password));
                }else if (phone.isEmpty()){
                    error(getString(R.string.phone));
                }else if (agee.isEmpty()){
                    error(getString(R.string.age));
                }else if(poblation.isEmpty()){
                    error(getString(R.string.poblation));
                }else if(email.isEmpty()){
                    error(getString(R.string.email));
                }else{
                    User user = new User(1,userName,password,name,surname,phone,age,poblation,email,true);
                    Intent intent = new Intent(UsuarioRegistrar.this,UsuarioServicioOferta.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void error(String str){
        Context context = getApplicationContext();
        CharSequence text = "El camp "+str+" no pot estar buit!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
