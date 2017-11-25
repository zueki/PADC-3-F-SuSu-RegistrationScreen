package com.helloworld.susu.hello_android_padc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by USER on 11/5/2017.
 */

public class LoginActivity extends AppCompatActivity {


    private static final String CORRECT_EMAIL = "susuoo93@gmail.com"; // constant attribute defines format (for only app not change)
    private static final String CORRECT_PASSWORD = "Abcdefg";


    private EditText etEmailOrPhone;
    private EditText etPassword;
    private Button btnLogin;
    private TextView btnForgetPwd;
    private TextView btnNewSellerRegister;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin =findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnForgetPwd = findViewById(R.id.btn_forget_pwd);
        btnNewSellerRegister = findViewById(R.id.btn_new_seller_register);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassword.getText().toString();

               if(TextUtils.isEmpty(emailOrPhone)){
                   etEmailOrPhone.setError("Email Or Phone can not be Empty");
                   return;
               }

               if(TextUtils.isEmpty(password)){
                   etPassword.setError("Password can not be Empty");
                   return;
               }


               if( TextUtils.equals(emailOrPhone,CORRECT_EMAIL) && TextUtils.equals(password,CORRECT_PASSWORD) )
               {
                   //Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                   Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                   startActivity(intent);
               }
               else {
                   Snackbar.make(v, "Incorrect Email or Password , Please Try Again", Snackbar.LENGTH_INDEFINITE).
                           setAction("Action", null).show();
               }




//                Snackbar.make(v, "Login button clicked", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Action", null).show();


            }
        });




        btnForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "\"Forget Password\" is coming soon", Snackbar.LENGTH_INDEFINITE).show();

            }
        });

        btnNewSellerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RegistrationFormActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });


    }

}
